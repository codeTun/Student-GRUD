package com.example.demo.student;

import java.util.List;


import org.springframework.stereotype.Service;

@Service //this is a service class
public class StudentService {

    private final StudentRepository studentRepository;

   
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> GetStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }

}
