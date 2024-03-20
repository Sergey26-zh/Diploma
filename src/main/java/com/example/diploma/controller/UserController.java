package com.example.diploma.controller;

import com.example.diploma.dto.RegistrationUserDto;
import com.example.diploma.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the unprotected page";
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String hello(){
        return "hello to the unprotected page";
    }

    @PostMapping("/registration")
    public RegistrationUserDto registration(@RequestBody @Valid RegistrationUserDto registrationUserDto) {
        return userService.registration(registrationUserDto);
    }
}
