package com.applaudostudios.week5assignment.service;

import com.applaudostudios.week5assignment.Mappers.UserMapperImpl;
import com.applaudostudios.week5assignment.exceptions.UserAlreadyExistsException;
import com.applaudostudios.week5assignment.exceptions.UserNotFoundException;
import com.applaudostudios.week5assignment.model.dto.UserDto;
import com.applaudostudios.week5assignment.model.entity.UserEntity;
import com.applaudostudios.week5assignment.projections.UserProjection;
import com.applaudostudios.week5assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final UserMapperImpl userMapper = new UserMapperImpl();
    @Override
    public UserDto saveUser(UserDto userDto) {

        String userEmail = userDto.getEmail();

        boolean userExists = this.verifyEmail(userEmail);

        if(userExists) {
            throw new UserAlreadyExistsException("The user already exists with the given email account");
        }

        UserEntity userEntity = this.userMapper.mapUserDtoToUserEntity(userDto);

        return this.userMapper.mapUserEntityToUserDto(this.userRepository.save(userEntity));

    }

    @Override
    public UserProjection getUserByUserEmail(String email) {

        boolean userExists = this.verifyEmail(email);

        if(userExists){
            return this.userRepository.findByUserEmail(email,UserProjection.class);
        }

        else {
            throw new UserNotFoundException("We could not find a user with the given email");
        }
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        Integer userId = userDto.getId();

        UserEntity userEntity = this.userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("We could not find a user with that UserId"));

        String userEmail = userEntity.getUserEmail();

        userEntity = this.userMapper.mapUserDtoToUserEntity(userDto);

        userEntity.setUserEmail(userEmail);

        return this.userMapper.mapUserEntityToUserDto(this.userRepository.save(userEntity));
    }

    @Override
    public List<UserProjection> getAllUsers() {

        return this.userRepository.findBy(UserProjection.class);

    }

    private boolean verifyEmail(String userEmail){

        UserEntity userEntity = this.userRepository.findByUserEmail(userEmail).orElse(null);

        if (userEntity != null){
            return true;
        }

        return false;
    }


}
