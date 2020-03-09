package com.example.firstApp.repository;

import com.example.firstApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

        @Query(value = "SELECT t FROM Student t WHERE t.username = :_username AND t.password = :_password")
        Optional<Student> findByUsername(String _username, String _password);
}
