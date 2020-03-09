package com.example.firstApp.controller;

import com.example.firstApp.exception.ModuleNotFoundException;
import com.example.firstApp.exception.StudentNotFoundException;
import com.example.firstApp.model.Module;
import com.example.firstApp.model.Student;
import com.example.firstApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.firstApp.repository.ModuleRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ModuleController {

    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", "Hello World !!!");
        System.out.println(studentRepository.toString());
        return "welcome";
    }

    @RequestMapping(value ="/view_classes/{user-id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("user-id") int userID, Model model) throws StudentNotFoundException {
        List<Student> listBooks = studentRepository.findAll();
        model.addAttribute("listStudents", listBooks);
        Optional<Student> returnedStudent = studentRepository.findById(4);

        if(returnedStudent.isPresent()){
            Student myStudent = returnedStudent.get();
            model.addAttribute("message", myStudent.getFirstName());
        }

        return "welcome";
        //return studentRepository.findById(userID).orElseThrow(()-> new StudentNotFoundException(userID));
    }

    // Get All Modules
    @GetMapping("/modules")
    public String getAllModules(Model model) {
        model.addAttribute("moduleList", moduleRepository.findAll());
        model.addAttribute("elemCount", moduleRepository.count());
        return "modules";
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

    @RequestMapping(value="welcome/{username}/modules/{username}/{password}", method = RequestMethod.GET)
    public String viewModules(@PathVariable("username") String username, @PathVariable("password") String password, Model model){
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute(moduleRepository.findAll());
        return "modules";
    }





}
