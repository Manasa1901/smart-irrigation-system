package com.example.Irrigation_System.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "water_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WaterLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Water volume is required")
    private Double waterVolume; // in liters or cubic meters

    @NotNull(message = "Log date is required")
    private LocalDateTime logTime;

    private String notes; // optional remarks

    // Many logs can belong to one field
    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;
}
