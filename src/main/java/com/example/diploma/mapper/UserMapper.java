package com.example.diploma.mapper;

import com.example.diploma.dto.RegistrationUserDto;
import com.example.diploma.dto.UserDto;
import com.example.diploma.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User toEntity(RegistrationUserDto userDto);
    RegistrationUserDto toDto(User user);
}
