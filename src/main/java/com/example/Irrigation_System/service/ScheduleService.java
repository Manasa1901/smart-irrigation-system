package com.example.Irrigation_System.service;

import com.example.Irrigation_System.entity.IrrigationSchedule;
import com.example.Irrigation_System.repository.IrrigationScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private final IrrigationScheduleRepository scheduleRepository;

    public ScheduleService(IrrigationScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<IrrigationSchedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Optional<IrrigationSchedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    public IrrigationSchedule saveSchedule(IrrigationSchedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public IrrigationSchedule updateSchedule(Long id, IrrigationSchedule updated) {
        return scheduleRepository.findById(id)
                .map(existing -> {
                    existing.setStartTime(updated.getStartTime());
                    existing.setEndTime(updated.getEndTime());
                    existing.setWaterAmount(updated.getWaterAmount());
                    existing.setStatus(updated.getStatus());
                    return scheduleRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Schedule not found with ID: " + id));
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    public List<IrrigationSchedule> getUpcomingSchedules() {
        return scheduleRepository.findByStartTimeAfter(LocalDateTime.now());
    }
}
