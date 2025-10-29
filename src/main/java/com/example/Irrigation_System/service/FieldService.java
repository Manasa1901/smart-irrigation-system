package com.example.Irrigation_System.service;

import com.example.Irrigation_System.entity.Field;
import com.example.Irrigation_System.repository.FieldRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService {

    private final FieldRepository fieldRepository;

    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    public Optional<Field> getFieldById(Long id) {
        return fieldRepository.findById(id);
    }

    public Field saveField(Field field) {
        return fieldRepository.save(field);
    }

    public Field updateField(Long id, Field updatedField) {
        return fieldRepository.findById(id)
                .map(existing -> {
                    existing.setFieldName(updatedField.getFieldName());
                    existing.setCropType(updatedField.getCropType());
                    existing.setSoilType(updatedField.getSoilType());
                    existing.setArea(updatedField.getArea());
                    return fieldRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Field not found with ID: " + id));
    }

    public void deleteField(Long id) {
        fieldRepository.deleteById(id);
    }
}
