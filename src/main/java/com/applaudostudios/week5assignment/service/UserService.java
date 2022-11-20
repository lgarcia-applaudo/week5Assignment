package com.applaudostudios.week5assignment.service;

import com.applaudostudios.week5assignment.model.dto.UserDto;
import com.applaudostudios.week5assignment.projections.UserProjection;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserDto userDto);

    UserProjection getUserByUserEmail(String userEmail);

    UserDto updateUser(UserDto userDto);

    List<UserProjection> getAllUsers();
}
