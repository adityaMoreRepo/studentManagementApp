package com.examp.studentclassservices.controller;

import com.examp.studentclassservices.VO.ResponseTemplateVO;
import com.examp.studentclassservices.entity.StudentClass;
import com.examp.studentclassservices.service.StudentClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class StudentClassController {
    @Autowired
    StudentClassService service;

    @GetMapping("/studentClasses")
    public List<StudentClass> getStudentClasses(){
        log.info("Inside getStudentClasses of StudentClassController");
        return service.getStudentClasses();
    }

    @GetMapping("/studentClassById/{id}")
    public StudentClass getStudentById(@PathVariable int id){
        log.info("Inside getStudentById method of StudentClassController");
        return service.getStudentById(id);
    }

    @GetMapping("/studentClass/{id}")
    public ResponseTemplateVO getStudentClassWithSubjects(@PathVariable int id){
        log.info("Inside getStudentClassWithSubjects of StudentClassController");
        return service.getStudentClassWithSubjects(id);
    }


}
