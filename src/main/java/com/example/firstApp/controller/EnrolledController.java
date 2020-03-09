package com.example.firstApp.controller;

import com.example.firstApp.model.Enrolled;
import com.example.firstApp.model.Student;
import com.example.firstApp.repository.EnrolledRepository;
import com.example.firstApp.repository.ModuleRepository;
import com.example.firstApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class EnrolledController {
    @Autowired
    ModuleRepository moduleRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    EnrolledRepository enrolledRepository;

    @RequestMapping("/home")
    public String addUserEnrolled(){

        Enrolled newEnrol = new Enrolled();
        newEnrol.setId(1L);
        Optional<Student> myStud = studentRepository.findByUsername("tester", "tester");
        if(myStud.isPresent()){
            newEnrol.setStudent(myStud.get());
        }
        newEnrol.setModule(moduleRepository.findByName("tester class"));
        newEnrol.setGrade("A");

        enrolledRepository.save(newEnrol);

        return "Home";
    }

    @RequestMapping(value="enroll/{moduleCode}/{username}/{password}", method = RequestMethod.GET)
    public String enrollStudent(@PathVariable("moduleCode") String moduleCode, @PathVariable("username") String username,
                                @PathVariable("password") String password, Model model){


        Enrolled newEnrol = new Enrolled();
        newEnrol.setId(1L);
        Optional<Student> myStudent = studentRepository.findByUsername(username, password);
        if(myStudent.isPresent()){
            Student stu = myStudent.get();
            Optional<Enrolled> enr = enrolledRepository.entryExists(moduleCode, "1");
            if(enr.isPresent()){
                return "redirect:/welcome/" + username + "/" + password +"/failed";
            }
            if(stu.getAccountBalance() < 0){
                return "redirect:/payFees/" + username + "/" + password;
            }
            newEnrol.setStudent(myStudent.get());
        }
        newEnrol.setModule(moduleRepository.findByName("Distributed Systems"));
        newEnrol.setGrade("-");
        enrolledRepository.save(newEnrol);



        return "redirect:/welcome/" + username + "/" + password;
    }

}
