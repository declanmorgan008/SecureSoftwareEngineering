package com.example.firstApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "enrolled")
public class Enrolled {
    @Id
    @GeneratedValue
    private int moduleCode;
//    @Id
//    @GeneratedValue
//    private int studentId;
    @NotBlank
    private String grade;

    public Enrolled(){
        super();
    }

    public Enrolled(int _moduleCode, int _studentId, String grade){
        super();
        this.moduleCode = _moduleCode;
        //this.studentId = _studentId;
        this.grade = grade;
    }

    public int getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(int moduleCode) {
        this.moduleCode = moduleCode;
    }

//    public int getStudentId() {
//        return studentId;
//    }

//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
