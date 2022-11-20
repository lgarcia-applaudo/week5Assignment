package com.applaudostudios.week5assignment.controller;

import com.applaudostudios.week5assignment.model.dto.UserDto;
import com.applaudostudios.week5assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "",produces = "application/json")
    public void createUser(@Valid @RequestBody UserDto userDto ){

      this.userService.saveUser(userDto);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "",produces = "application/json")
    public ResponseEntity<Object> getAllUsers( ){

        return new ResponseEntity<>(this.userService.getAllUsers(),HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "",produces = "application/json")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserDto userDto ){

            return new ResponseEntity<>(this.userService.updateUser(userDto),HttpStatus.OK);


    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/{email}", produces = "application/json")
    public void getByUserEmail(@PathVariable("email") String userEmail){

        this.userService.getUserByUserEmail(userEmail);
    }

}
