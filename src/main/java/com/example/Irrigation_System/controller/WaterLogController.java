package com.example.Irrigation_System.controller;

import com.example.Irrigation_System.entity.WaterLog;
import com.example.Irrigation_System.service.WaterLogService;
import com.example.Irrigation_System.service.FieldService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/logs")
public class WaterLogController {

    private final WaterLogService waterLogService;
    private final FieldService fieldService;

    public WaterLogController(WaterLogService waterLogService, FieldService fieldService) {
        this.waterLogService = waterLogService;
        this.fieldService = fieldService;
    }

    // List all logs
    @GetMapping
    public String listLogs(Model model) {
        model.addAttribute("logs", waterLogService.getAllLogs());
        return "logs/list"; // --> templates/logs/list.html
    }

    // Show form to add new log
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("log", new WaterLog());
        model.addAttribute("fields", fieldService.getAllFields());
        return "logs/add";
    }

    // Save new log
    @PostMapping
    public String saveLog(@ModelAttribute("log") WaterLog log) {
        waterLogService.saveLog(log);
        return "redirect:/logs";
    }

    // Delete log
    @GetMapping("/delete/{id}")
    public String deleteLog(@PathVariable Long id) {
        waterLogService.deleteLog(id);
        return "redirect:/logs";
    }
}
