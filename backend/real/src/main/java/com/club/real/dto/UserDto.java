package com.club.real.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
  private Long id;
  private String fullName;
  private String email;
  private String password; // Password will be received here from the client
  private String department;
  private String batch;
}
