package com.myapp;

import java.util.ArrayList;
import java.util.List;

public class RegistrationPortal {
    public List<Student> registeredStudents = new ArrayList<Student>();
    
    private RegistrationPortal(){        
    }
    private final static RegistrationPortal portal=new RegistrationPortal();
    public static RegistrationPortal getRegistrationPortal(){
        return portal;
    }

    public synchronized void register(Student st){
        registeredStudents.add(st);
    }
    
    public List<Student> getRegisteredStudents(){
        return registeredStudents;
    }
}

class Student {
    private final String id;
    private final String name;
    
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
}