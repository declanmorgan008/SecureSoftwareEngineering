package com.example.firstApp.repository;
import com.example.firstApp.model.Enrolled;
import com.example.firstApp.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnrolledRepository extends JpaRepository<Enrolled, Integer>{

        @Query(value = "SELECT t FROM Enrolled t WHERE t.module.moduleCode = :_code AND t.student.studentId = :_id")
        Optional<Enrolled> entryExists(String _code, String _id);
}
