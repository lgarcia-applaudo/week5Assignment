package com.applaudostudios.week5assignment.Mappers;

import com.applaudostudios.week5assignment.model.dto.UserDto;
import com.applaudostudios.week5assignment.model.entity.UserEntity;

public interface UserMapper {

    UserDto mapUserEntityToUserDto(UserEntity userEntity);

    UserEntity mapUserDtoToUserEntity(UserDto userDto);
}
