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

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exists"));

        if (name != null && name.length() > 0 && !student.getStudentName().equals(name)) {
            student.setStudentName(name);
        }

        if (email != null && email.length() > 0 && !student.getStudentEmail().equals(email)) {
            student.setStudentEmail(email);
        }
    }

}
