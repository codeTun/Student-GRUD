package com.example.demo.student;

import java.util.List;

import org.springframework.web.bind.annotation.*;

//All recources about API will be here
@RestController
@RequestMapping(path = "api/v1/student")

public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> GetStudent() {
        return studentService.GetStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

}
