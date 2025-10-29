package com.example.Irrigation_System.controller;

import com.example.Irrigation_System.entity.WaterLog;
import com.example.Irrigation_System.service.WaterLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waterlogs")
@CrossOrigin(origins = "*")
public class WaterLogController {

    private final WaterLogService waterLogService;

    public WaterLogController(WaterLogService waterLogService) {
        this.waterLogService = waterLogService;
    }

    // Get all water logs
    @GetMapping
    public ResponseEntity<List<WaterLog>> getAllLogs() {
        return ResponseEntity.ok(waterLogService.getAllLogs());
    }

    // Get a single water log
    @GetMapping("/{id}")
    public ResponseEntity<WaterLog> getLogById(@PathVariable Long id) {
        return waterLogService.getLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new log
    @PostMapping
    public ResponseEntity<WaterLog> createLog(@RequestBody WaterLog log) {
        return ResponseEntity.ok(waterLogService.saveLog(log));
    }

    // Update an existing log
    @PutMapping("/{id}")
    public ResponseEntity<WaterLog> updateLog(@PathVariable Long id, @RequestBody WaterLog updatedLog) {
        return ResponseEntity.ok(waterLogService.updateLog(id, updatedLog));
    }

    // Delete a log
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        waterLogService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }
}
