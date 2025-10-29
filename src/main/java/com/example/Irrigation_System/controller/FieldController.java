package com.example.Irrigation_System.controller;

import com.example.Irrigation_System.entity.Field;
import com.example.Irrigation_System.service.FieldService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fields")
public class FieldController {

    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    // Show all fields
    @GetMapping
    public String listFields(Model model) {
        model.addAttribute("fields", fieldService.getAllFields());
        return "fields/list"; // --> templates/fields/list.html
    }

    // Show form to add new field
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("field", new Field());
        return "fields/add"; // --> templates/fields/add.html
    }

    // Save new field
    @PostMapping
    public String saveField(@ModelAttribute("field") Field field) {
        fieldService.saveField(field);
        return "redirect:/fields";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Field field = fieldService.getFieldById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid field ID: " + id));
        model.addAttribute("field", field);
        return "fields/edit"; // --> templates/fields/edit.html
    }

    // Update field
    @PostMapping("/update/{id}")
    public String updateField(@PathVariable Long id, @ModelAttribute Field updatedField) {
        fieldService.updateField(id, updatedField);
        return "redirect:/fields";
    }

    // Delete field
    @GetMapping("/delete/{id}")
    public String deleteField(@PathVariable Long id) {
        fieldService.deleteField(id);
        return "redirect:/fields";
    }
}
