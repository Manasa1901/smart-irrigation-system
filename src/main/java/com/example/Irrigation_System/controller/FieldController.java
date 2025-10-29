package com.example.Irrigation_System.controller;

import com.example.Irrigation_System.entity.Field;
import com.example.Irrigation_System.service.FieldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fields")
@CrossOrigin(origins = "*")
public class FieldController {

    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    // Get all fields
    @GetMapping
    public List<Field> getAllFields() {
        return fieldService.getAllFields();
    }

    // Get field by ID
    @GetMapping("/{id}")
    public ResponseEntity<Field> getFieldById(@PathVariable Long id) {
        return fieldService.getFieldById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add new field
    @PostMapping
    public Field addField(@RequestBody Field field) {
        return fieldService.saveField(field);
    }

    // Update existing field
    @PutMapping("/{id}")
    public ResponseEntity<Field> updateField(@PathVariable Long id, @RequestBody Field updatedField) {
        Field field = fieldService.updateField(id, updatedField);
        return (field != null) ? ResponseEntity.ok(field) : ResponseEntity.notFound().build();
    }

    // Delete field
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteField(@PathVariable Long id) {
        fieldService.deleteField(id);
        return ResponseEntity.noContent().build();
    }
}
