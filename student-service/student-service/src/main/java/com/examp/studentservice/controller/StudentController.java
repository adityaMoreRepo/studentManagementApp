package com.examp.studentservice.controller;

import com.examp.studentservice.entity.Student;
import com.examp.studentservice.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        log.info("Inside addStudent method of StudentController");
        return studentService.addStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        log.info("Inside getAllStudents method inside StudentController");
        return studentService.getStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        log.info("Inside getStudentById method inside StudentController");
        return studentService.getStudentById(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
        log.info("Inside updateStudent method inside StudentController");
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity removeStudent(@PathVariable int id) {
        log.info("Inside removeStudent method inside StudentController");
        return studentService.removeStudent(id);
    }

}

