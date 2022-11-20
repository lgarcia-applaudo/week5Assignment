package com.applaudostudios.week5assignment.Mappers;

import com.applaudostudios.week5assignment.model.dto.UserDto;
import com.applaudostudios.week5assignment.model.entity.UserEntity;

public class UserMapperImpl implements UserMapper{

    @Override
    public UserDto mapUserEntityToUserDto(UserEntity userEntity) {
        if(userEntity != null ){

            return new UserDto.Builder()
                    .id(userEntity.getUserId())
                    .firstName(userEntity.getUserFirstName())
                    .lastName(userEntity.getUserLastName())
                    .email(userEntity.getUserEmail())
                    .phoneNumber(userEntity.getUserPhoneNumber())
                    .build();
        }

        return null;
    }

    @Override
    public UserEntity mapUserDtoToUserEntity(UserDto userDto) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDto.getId());
        userEntity.setUserEmail(userDto.getEmail());
        userEntity.setUserFirstName(userDto.getFirstName());
        userEntity.setUserLastName(userDto.getLastName());
        userEntity.setUserPhoneNumber(userDto.getPhoneNumber());

        return userEntity;
    }
}
