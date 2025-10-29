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

    public List<WaterLog> getAllLogs() {
        return waterLogRepository.findAll();
    }

    public Optional<WaterLog> getLogById(Long id) {
        return waterLogRepository.findById(id);
    }

    public List<WaterLog> getLogsByFieldId(Long fieldId) {
        return waterLogRepository.findByFieldId(fieldId);
    }

    public WaterLog saveLog(WaterLog log) {
        return waterLogRepository.save(log);
    }

    public void deleteLog(Long id) {
        waterLogRepository.deleteById(id);
    }
}
