package com.club.real.mapper;

import com.club.real.dto.UserDto;
import com.club.real.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {

    public static User mapToUser(UserDto userDto) {
        // Create BCryptPasswordEncoder instance to hash the password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Hash the password before storing it
        String hashedPassword = passwordEncoder.encode(userDto.getPassword());

        // Map the rest of the fields and return the User entity
        return new User(
            userDto.getId(),
            userDto.getFullName(),
            userDto.getEmail(),
            hashedPassword,  // Store the hashed password
            userDto.getDepartment(),
            userDto.getBatch()
        );
    }

    public static UserDto mapToUserDto(User user) {
        return new UserDto(
            user.getId(),
            user.getFullName(),
            user.getEmail(),
            user.getDepartment(),
            user.getBatch(),
            null  // Never send the password back in the response
        );
    }
}
