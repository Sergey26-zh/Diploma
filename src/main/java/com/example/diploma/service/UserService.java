package com.example.diploma.service;

import com.example.diploma.dto.RegistrationUserDto;
import com.example.diploma.entity.User;
import com.example.diploma.exception.UserAlreadyExistsException;
import com.example.diploma.mapper.UserMapper;
import com.example.diploma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public RegistrationUserDto registration(RegistrationUserDto registrationUserDto){
        if (userRepository.existsUserByEmail(registrationUserDto.getEmail())) {
            throw new UserAlreadyExistsException(String.format("User with email %s Already Exists",
                    registrationUserDto.getEmail()));
        }

        if (!registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword())) {
            throw new RuntimeException("Password is not equals");
        }

        String encodedPassword = passwordEncoder.encode(registrationUserDto.getPassword());
        User user = userMapper.toEntity(registrationUserDto);
        user.setPassword(encodedPassword);
        user.setRoles("ROLE_USER");
        userRepository.save(user);

        return userMapper.toDto(user);
    }
}
