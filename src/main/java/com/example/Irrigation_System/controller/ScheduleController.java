package com.example.Irrigation_System.controller;

import com.example.Irrigation_System.entity.IrrigationSchedule;
import com.example.Irrigation_System.service.ScheduleService;
import com.example.Irrigation_System.service.FieldService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final FieldService fieldService;

    public ScheduleController(ScheduleService scheduleService, FieldService fieldService) {
        this.scheduleService = scheduleService;
        this.fieldService = fieldService;
    }

    // List all schedules
    @GetMapping
    public String listSchedules(Model model) {
        model.addAttribute("schedules", scheduleService.getAllSchedules());
        return "schedules/list"; // --> templates/schedules/list.html
    }

    // Show form to add schedule
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("schedule", new IrrigationSchedule());
        model.addAttribute("fields", fieldService.getAllFields()); // Dropdown for field selection
        return "schedules/add"; // --> templates/schedules/add.html
    }

    // Save new schedule
    @PostMapping
    public String saveSchedule(@ModelAttribute("schedule") IrrigationSchedule schedule) {
        scheduleService.saveSchedule(schedule);
        return "redirect:/schedules";
    }

    // Edit schedule
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        IrrigationSchedule schedule = scheduleService.getScheduleById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));
        model.addAttribute("schedule", schedule);
        model.addAttribute("fields", fieldService.getAllFields());
        return "schedules/edit";
    }

    // Update schedule
    @PostMapping("/update/{id}")
    public String updateSchedule(@PathVariable Long id, @ModelAttribute IrrigationSchedule updatedSchedule) {
        scheduleService.updateSchedule(id, updatedSchedule);
        return "redirect:/schedules";
    }

    // Delete schedule
    @GetMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return "redirect:/schedules";
    }
}
