package com.example.firstApp.exception;

public class ModuleNotFoundException extends Exception {
    private long module_code;

    public ModuleNotFoundException(long module_code){
        super(String.format("Student not found with id: '%s'", module_code));
    }
}
