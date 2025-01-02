package com.club.real.service.impl;

import org.springframework.stereotype.Service;

import com.club.real.dto.UserDto;
import com.club.real.mapper.UserMapper;
import com.club.real.model.User;
import com.club.real.repository.UserRepository;
import com.club.real.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;  // Injected via constructor

  @Override
  public UserDto createUser(UserDto userDto) {
    // Convert DTO to Entity
    User user = UserMapper.mapToUser(userDto);

    // Save the entity to the database
    User savedUser = userRepository.save(user);

    // Convert saved entity back to DTO
    return UserMapper.mapToUserDto(savedUser);
  }
}
