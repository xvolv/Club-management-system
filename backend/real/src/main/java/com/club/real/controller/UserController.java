package com.club.real.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.club.real.dto.UserDto;
import com.club.real.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService; // Constructor injection is recommended

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
    // Calling the service to create a new user
    UserDto savedUser = userService.createUser(userDto);

    // Returning the created user along with a CREATED status
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
  }

}
