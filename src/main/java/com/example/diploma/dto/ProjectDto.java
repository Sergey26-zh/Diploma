package com.example.diploma.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProjectDto {
    @NotBlank(message = "The name cannot be empty")
    private String name;
    private String description;

    @NotBlank(message = "Field \"location\" cannot be empty")
    private String location;

    @NotNull(message = "Set the start date")
    private LocalDate startDate;

    @NotNull(message = "Set the end date")
    private LocalDate endDate;
    private Long userId;
}
