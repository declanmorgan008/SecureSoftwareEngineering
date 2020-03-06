package com.example.firstApp.repository;

import com.example.firstApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

        Student findByUsername(String username);

}
