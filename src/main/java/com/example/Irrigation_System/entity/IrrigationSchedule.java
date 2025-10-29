package com.example.Irrigation_System.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "irrigation_schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IrrigationSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Start time is required")
    @FutureOrPresent(message = "Start time cannot be in the past")
    private LocalDateTime startTime;

    @NotNull(message = "End time is required")
    @FutureOrPresent(message = "End time cannot be in the past")
    private LocalDateTime endTime;

    @NotNull(message = "Water amount is required")
    private Double waterAmount; // in liters or cubic meters

    @NotBlank(message = "Status is required")
    private String status; // Example: "Scheduled", "Completed", "Cancelled"

    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;
}
