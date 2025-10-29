package com.example.Irrigation_System.repository;

import com.example.Irrigation_System.entity.IrrigationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IrrigationScheduleRepository extends JpaRepository<IrrigationSchedule, Long> {
    // Fetch schedules for a specific field
    List<IrrigationSchedule> findByFieldId(Long fieldId);

    // Optional: find upcoming schedules
    List<IrrigationSchedule> findByStartTimeAfter(LocalDateTime now);
}
