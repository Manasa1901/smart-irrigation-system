package com.example.Irrigation_System.repository;

import com.example.Irrigation_System.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {
    // Custom query example: find all fields owned by a specific user
    List<Field> findByOwnerId(Long ownerId);
}
