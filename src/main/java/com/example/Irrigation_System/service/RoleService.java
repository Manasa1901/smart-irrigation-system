package com.example.Irrigation_System.service;

import com.example.Irrigation_System.entity.Role;
import com.example.Irrigation_System.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // Get all roles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Get single role by ID
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    // Create new role
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    // Update role
    public Role updateRole(Long id, Role updatedRole) {
        return roleRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedRole.getName());
                    return roleRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    }

    // Delete role
    public void deleteRole(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Role not found with id " + id);
        }
    }
}
