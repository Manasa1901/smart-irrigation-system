package com.example.Irrigation_System.repository;

import com.example.Irrigation_System.entity.WaterLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterLogRepository extends JpaRepository<WaterLog, Long> {
    // Find all water logs for a given field
    List<WaterLog> findByFieldId(Long fieldId);
}
