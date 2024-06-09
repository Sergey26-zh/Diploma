package com.example.diploma.controller;

import com.example.diploma.dto.ProjectDto;
import com.example.diploma.dto.RegistrationUserDto;
import com.example.diploma.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration"; // возвращаем имя HTML-шаблона (без расширения)
    }

    @PostMapping("/registration")
    public ResponseEntity<RegistrationUserDto> registration(@RequestBody @Valid RegistrationUserDto registrationUserDto) {
        return new ResponseEntity<>(registrationUserDto, HttpStatus.CREATED);
    }
}
