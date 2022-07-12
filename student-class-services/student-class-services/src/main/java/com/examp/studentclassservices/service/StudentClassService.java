package com.examp.studentclassservices.service;

import com.examp.studentclassservices.VO.ResponseTemplateVO;
import com.examp.studentclassservices.entity.StudentClass;
import com.examp.studentclassservices.entity.Subject;
import com.examp.studentclassservices.repository.StudentClassRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class StudentClassService {
    @Autowired
    StudentClassRepository repository;

    @Autowired
    RestTemplate restTemplate;

    public List<StudentClass> getStudentClasses() {
        log.info("Inside getStudentClasses method of StudentClassService");
        return repository.findAll();
    }

    public StudentClass getStudentById(int id) {
        log.info("Inside getStudentById method of StudentClassService");
        return repository.findById(id).orElse(null);
    }


    public ResponseTemplateVO getStudentClassWithSubjects(int id) {
        log.info("Inside getStudentClassWithClassWithSubjects method of StudentClassService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        StudentClass studentClass = repository.findById(id).orElse(null);
        Subject subject = restTemplate.getForObject("http://localhost:9192/subject/1", Subject.class);
        vo.setStudentClass(studentClass);
        vo.setSubject(subject);
        return vo;
    }

}
