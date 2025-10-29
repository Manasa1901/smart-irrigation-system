package com.example.Irrigation_System.service;

import com.example.Irrigation_System.entity.WaterLog;
import com.example.Irrigation_System.repository.WaterLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaterLogService {

    private final WaterLogRepository waterLogRepository;

    public WaterLogService(WaterLogRepository waterLogRepository) {
        this.waterLogRepository = waterLogRepository;
    }

    // Get all logs
    public List<WaterLog> getAllLogs() {
        return waterLogRepository.findAll();
    }

    // Get one log
    public Optional<WaterLog> getLogById(Long id) {
        return waterLogRepository.findById(id);
    }

    // Save a new log
    public WaterLog saveLog(WaterLog log) {
        return waterLogRepository.save(log);
    }

    // Update log
    public WaterLog updateLog(Long id, WaterLog updatedLog) {
        return waterLogRepository.findById(id)
                .map(existing -> {
                    existing.setWaterVolume(updatedLog.getWaterVolume());
                    existing.setLogTime(updatedLog.getLogTime());
                    existing.setNotes(updatedLog.getNotes());
                    existing.setField(updatedLog.getField());
                    return waterLogRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("WaterLog not found with id " + id));
    }

    // Delete log
    public void deleteLog(Long id) {
        if (waterLogRepository.existsById(id)) {
            waterLogRepository.deleteById(id);
        } else {
            throw new RuntimeException("WaterLog not found with id " + id);
        }
    }
}
