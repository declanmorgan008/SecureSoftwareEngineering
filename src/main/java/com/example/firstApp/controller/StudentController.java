package com.example.firstApp.controller;

import com.example.firstApp.exception.StudentNotFoundException;
import com.example.firstApp.model.Student;
import com.example.firstApp.service.SecurityService;
import com.example.firstApp.service.StudentService;
import com.example.firstApp.utils.PassEncoding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.firstApp.repository.StudentRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentRepository studentRepository;


    @Autowired
    StudentService studentService;



    @Autowired
    private SecurityService securityService;


    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userForm", new Student());

        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") Student userForm, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return "register";
        }

        studentService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPassword());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }


//    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
//    public String register(Model model) {
//        model.addAttribute("reqUser", new Student());
//
//        return "register";
//    }
//
//    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
//    public String register(@ModelAttribute("reqUser") Student reqUser,
//                           final RedirectAttributes redirectAttributes) {
//
//
//        System.out.println(reqUser.getEmail() + " " + reqUser.getRole());
//        Student user = studentService.findByEmail(reqUser.getEmail());
//        if (user != null) {
//            redirectAttributes.addFlashAttribute("saveUser", "exist-email");
//            return "redirect:/register";
//        }
//
//        reqUser.setPassword(PassEncoding.getInstance().passwordEncoder.encode(reqUser.getPassword()));
//        reqUser.setRole(Roles.ROLE_USER.getValue());
//
//        if (studentService.save(reqUser) != null) {
//            redirectAttributes.addFlashAttribute("saveUser", "success");
//        } else {
//            redirectAttributes.addFlashAttribute("saveUser", "fail");
//        }
//
//        return "redirect:/register";
//    }

    // Get all Students
    @GetMapping("/students/all")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    // Create a new Student
    @PostMapping("/students/add")
    public Student createStudent(@Valid @RequestBody Student _student) {
        return studentRepository.save(_student);
    }

    // Get a Single Student
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable(value = "id") int _studentId) throws StudentNotFoundException {
        return studentRepository.findById(_studentId)
                .orElseThrow(() -> new StudentNotFoundException(_studentId));
    }

    // Update a Students Details
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable(value = "id") int _studentId,
                           @Valid @RequestBody Student _studentDetails) throws StudentNotFoundException {
        //Find the student by ID
        Student student = studentRepository.findById(_studentId)
                .orElseThrow(() -> new StudentNotFoundException(_studentId));

        //Update the student details
        student.setFirstName(_studentDetails.getFirstName());
        student.setLastName(_studentDetails.getLastName());
        student.setAddress(_studentDetails.getAddress());
        student.setEmail(_studentDetails.getEmail());
        student.setPhoneNumber(_studentDetails.getPhoneNumber());
        Student updatedStudent = studentRepository.save(student);

        //Return the updated student object
        return updatedStudent;
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") int _studentId) throws StudentNotFoundException {
        Student student = studentRepository.findById(_studentId)
                .orElseThrow(() -> new StudentNotFoundException(_studentId));

        studentRepository.delete(student);
        return ResponseEntity.ok().build();
    }
}
