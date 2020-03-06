package com.example.firstApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "modules")
public class Module {
    @Id
    @GeneratedValue
    private int moduleCode;
    @NotBlank
    private String name;
    @NotBlank
    private String topics;
    @NotBlank
    private String coordinator;
    @NotBlank
    private int availableSlots;
    @NotBlank
    private int registeredStudents;
    @NotBlank
    private String startDate;
    @NotBlank
    private String endDate;

    public Module(){
        super();
    }

    public Module(int _code, String _name, String _topics, String _coordinator, int _availableSlots,
                    int _registeredStudents, String _startDate, String _endDate){
        super();
        this.moduleCode = _code;
        this.name = _name;
        this.topics = _topics;
        this.coordinator = _coordinator;
        this.availableSlots = _availableSlots;
        this.registeredStudents = _registeredStudents;
        this.startDate = _startDate;
        this.endDate = _endDate;
    }

    public int getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(int moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(int registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
