package com.example.Irrigation_System.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "fields")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Field name is required")
    private String fieldName;

    @NotBlank(message = "Crop type is required")
    private String cropType;

    private double area;

    private String soilType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

}
