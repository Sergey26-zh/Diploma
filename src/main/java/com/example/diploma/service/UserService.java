package com.example.diploma.service;

import com.example.diploma.dto.RegistrationUserDto;
import com.example.diploma.entity.User;
import com.example.diploma.exception.UserAlreadyExistsException;
import com.example.diploma.mapper.UserMapper;
import com.example.diploma.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Transactional
    public RegistrationUserDto registration(RegistrationUserDto registrationUserDto){
        if (!registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword())) {
            throw new IllegalArgumentException("Password mismatch");
        }

        if (userRepository.existsUserByEmail(registrationUserDto.getEmail())) {
            throw new UserAlreadyExistsException("A user with this email already exists");
        }

        String encodedPassword = encodePassword(registrationUserDto.getPassword());
        registrationUserDto.setPassword(encodedPassword);

        User user = userRepository.save(userMapper.toEntity(registrationUserDto));
        return userMapper.toDto(user);
    }

    private String encodePassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
