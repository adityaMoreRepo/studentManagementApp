package com.examp.subjectservices.service;


import com.examp.subjectservices.entity.Subject;
import com.examp.subjectservices.exception.SubjectNotFoundException;
import com.examp.subjectservices.repository.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public Subject saveSubject(Subject subject){
        log.info("Inside saveSubject method of SubjectRepository");
        return subjectRepository.save(subject);
    }

    public List<Subject> saveSubjects(List<Subject> subjects){
        log.info("Inside saveSubjects method of SubjectRepository");
        return subjectRepository.saveAll(subjects);
    }

    public Subject getSubjectById(int id){
        log.info("Inside getSubjectById method of SubjectRepository");
        return subjectRepository.findById(id).orElse(null);
    }

    public Page<Subject> getSubjectsByPagination(Pageable pageable){
        log.info("Inside getSubjectsByPagination method of SubjectRepository");
        //we can also return the List<Subject>
        //List<Subject> subjects = subjectRepository.findAll(pageable).getContent();
        return subjectRepository.findAll(pageable);
    }

    public Subject updateSubject(Subject requestSubject, int id) throws Exception{
        log.info("Inside updateSubject method of SubjectRepository");
        return subjectRepository.findById(id).map((subject) -> {
            subject.setSub_name(requestSubject.getSub_name());
            subject.setMarks_obtained(requestSubject.getMarks_obtained());
            subject.setPassing_marks(requestSubject.getPassing_marks());
            subject.setTotal_marks(requestSubject.getTotal_marks());
            return subjectRepository.save(subject);
        }).orElseThrow(() -> new SubjectNotFoundException("Subject id " + id + " is not valid"));
    }
    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    public ResponseEntity<Subject> removeSubject(int id) {
        Subject subject =new Subject();
        try{
            subject = subjectRepository.findById(id)
                    .orElseThrow(() -> new SubjectNotFoundException("The Student id " + id +" not found"));
        }
        catch (SubjectNotFoundException e){
            e.printStackTrace();
        }
        this.subjectRepository.delete(subject);
        return ResponseEntity.ok().build();

    }
}
