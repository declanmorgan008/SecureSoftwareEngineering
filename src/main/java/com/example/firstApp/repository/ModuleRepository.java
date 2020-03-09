package com.example.firstApp.repository;

import com.example.firstApp.model.Module;
import com.example.firstApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    @Query(value = "SELECT t FROM Module t WHERE t.name = :_name")
    Module findByName(String _name);

    @Query(value = "SELECT t FROM Module t WHERE t.moduleCode = :_code")
    Module findByCode(String _code);

}
