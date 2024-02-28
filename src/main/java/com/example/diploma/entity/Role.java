package com.example.diploma.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 64, nullable = false, unique = true)
    private String name;

    public static final String ADMIN = "admin";
    public static final String EDITOR = "editor";
    public static final String PARTICIPANT = "participant";
}
