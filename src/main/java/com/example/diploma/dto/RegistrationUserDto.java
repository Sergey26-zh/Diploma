package com.example.diploma.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegistrationUserDto {

    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @NotBlank(message = "Email name cannot be empty")
    @Email(message = "Invalid email format")
    private String email;
    private LocalDate birthdate;

    @NotBlank(message = "Position name cannot be empty")
    private String position;

    @NotBlank(message = "Password name cannot be empty")
    private String password;

    @NotBlank(message = "Password confirm name cannot be empty")
    private String confirmPassword;
}
