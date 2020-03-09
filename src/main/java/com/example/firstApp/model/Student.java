package com.example.firstApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "students_webapp")
public class Student {
    @Id
    @GeneratedValue
    private String studentId;
    @NotBlank
    private String firstName;
    @NotBlank

    private String lastName;
    @NotBlank
    private String address;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    private double accountBalance;

    @OneToMany(mappedBy = "student")
    Set<Enrolled> enrolledSet;


    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Set<Enrolled> getEnrolledSet() {
        return enrolledSet;
    }

    public void setEnrolledSet(Set<Enrolled> enrolledSet) {
        this.enrolledSet = enrolledSet;
    }

    public Student(){
        super();
    }

    public Student(String firstName, String lastName, String phoneNumber, String email, String address, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getStudentId() {
        return studentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


}
