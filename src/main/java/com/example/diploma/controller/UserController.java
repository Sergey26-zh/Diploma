package com.example.diploma.controller;

import com.example.diploma.dto.RegistrationUserDto;
import com.example.diploma.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<RegistrationUserDto> registerUser(@RequestBody @Valid RegistrationUserDto registrationUserDto) {
        RegistrationUserDto registeredUserDto = userService.registration(registrationUserDto);
        return new ResponseEntity<>(registeredUserDto, HttpStatus.CREATED);
    }
}
