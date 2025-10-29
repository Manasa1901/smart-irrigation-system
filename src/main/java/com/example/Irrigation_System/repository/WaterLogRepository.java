package com.example.Irrigation_System.repository;

import com.example.Irrigation_System.entity.WaterLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterLogRepository extends JpaRepository<WaterLog, Long> {

}
