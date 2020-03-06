package com.example.firstApp.controller;

import com.example.firstApp.exception.ModuleNotFoundException;
import com.example.firstApp.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.firstApp.repository.ModuleRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ModuleController {

    @Autowired
    ModuleRepository moduleRepository;

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", "Hello World !!!");
        return "home";
    }

    // Get All Modules
    @GetMapping("/modules")
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    // Create a new Module
    @PostMapping("/modules")
    public Module createModule(@Valid @RequestBody Module module) {
        return moduleRepository.save(module);
    }

    // Get a Single Module
    @GetMapping("/modules/{id}")
    public Module getModuleById(@PathVariable(value = "id") Long moduleId) throws ModuleNotFoundException {
        return moduleRepository.findById(moduleId)
                .orElseThrow(() -> new ModuleNotFoundException(moduleId));
    }

    // Update a Module
    @PutMapping("/modules/{id}")
    public Module updateModule(@PathVariable(value = "id") Long moduleId,
                           @Valid @RequestBody Module moduleDetails) throws ModuleNotFoundException {

        Module module =  moduleRepository.findById(moduleId)
                .orElseThrow(() -> new ModuleNotFoundException(moduleId));

        module.setName(moduleDetails.getName());
        module.setTopics(moduleDetails.getTopics());
        module.setCoordinator(moduleDetails.getCoordinator());
        module.setAvailableSlots(moduleDetails.getAvailableSlots());
        module.setStartDate(moduleDetails.getStartDate());
        module.setEndDate(moduleDetails.getEndDate());

        Module updatedModule = moduleRepository.save(module);

        return updatedModule;

    }

    // Delete a Module
    @DeleteMapping("/modules/{id}")
    public ResponseEntity<?> deleteModule(@PathVariable(value = "id") Long moduleId) throws ModuleNotFoundException {
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new ModuleNotFoundException(moduleId));

        moduleRepository.delete(module);

        return ResponseEntity.ok().build();
    }

}
