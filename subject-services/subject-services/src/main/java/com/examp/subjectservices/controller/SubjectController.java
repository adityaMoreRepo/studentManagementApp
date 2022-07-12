package com.examp.subjectservices.controller;

import com.examp.subjectservices.entity.Subject;
import com.examp.subjectservices.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SubjectController {

    @Autowired
    private SubjectService service;

    @PostMapping("/addSubject")
    public Subject addSubject(@RequestBody Subject subject){
        log.info("Inside addSubject method of SubjectService");
        return service.saveSubject(subject);
    }

//    @GetMapping("/subjects")
//    public List<Subject> findAllSubjects(){
//        return service.getSubjects();
//    }

    @GetMapping("/subjects")
    public Page<Subject> findAllSubjects(Pageable pageable){
        log.info("Inside findAllSubjects method of SubjectService");
        return service.getSubjectsByPagination(pageable);
    }

    @PutMapping("/subject/{id}")
    public Subject updateSubject(@RequestBody Subject subject, @PathVariable int id) throws Exception {
        log.info("Inside updateSubject method of SubjectService");
        return service.updateSubject(subject, id);
    }

    @GetMapping("/subject/{id}")
    public Subject findSubjectById(@PathVariable int id){
        log.info("Inside findSubjectById method of SubjectService");
        return service.getSubjectById(id);
    }

    @DeleteMapping("/subject/{id}")
    public ResponseEntity removeSubject(@PathVariable int id){
        log.info("Inside removeSubject method of SubjectService");
        return service.removeSubject(id);
    }
}