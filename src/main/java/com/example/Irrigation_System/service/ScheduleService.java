package com.example.Irrigation_System.service;

import com.example.Irrigation_System.entity.IrrigationSchedule;
import com.example.Irrigation_System.repository.IrrigationScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private final IrrigationScheduleRepository scheduleRepository;

    public ScheduleService(IrrigationScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // ✅ Get all schedules
    public List<IrrigationSchedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    // ✅ Get schedule by ID (returns Optional)
    public Optional<IrrigationSchedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    // ✅ Save or update a schedule
    public IrrigationSchedule saveSchedule(IrrigationSchedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // ✅ Delete a schedule by ID
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
