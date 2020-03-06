package com.example.firstApp.service;

import com.example.firstApp.model.Student;

import java.util.Collection;

public interface StudentService {
    void save(Student user);

    Student findByUsername(String username);
}
