package com.example.Irrigation_System.controller;

import com.example.Irrigation_System.entity.IrrigationSchedule;
import com.example.Irrigation_System.service.ScheduleService;
import com.example.Irrigation_System.service.FieldService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService, FieldService fieldService) {
        this.scheduleService = scheduleService;
    }

    // Get all schedules
    @GetMapping
    public List<IrrigationSchedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    // Get schedule by ID
    @GetMapping("/{id}")
    public IrrigationSchedule getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));
    }

    // Create new schedule
    @PostMapping
    public IrrigationSchedule createSchedule(@RequestBody IrrigationSchedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    // Update schedule
    @PutMapping("/{id}")
    public IrrigationSchedule updateSchedule(@PathVariable Long id, @RequestBody IrrigationSchedule updatedSchedule) {
        IrrigationSchedule existing = scheduleService.getScheduleById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));

        existing.setStartTime(updatedSchedule.getStartTime());
        existing.setEndTime(updatedSchedule.getEndTime());
        existing.setWaterAmount(updatedSchedule.getWaterAmount());
        existing.setField(updatedSchedule.getField());

        return scheduleService.saveSchedule(existing);
    }

    // Delete schedule
    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return "Schedule deleted successfully";
    }
}
