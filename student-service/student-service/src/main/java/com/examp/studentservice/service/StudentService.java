package com.examp.studentservice.service;

import com.examp.studentservice.entity.Student;
import com.examp.studentservice.exception.StudentNotFoundException;
import com.examp.studentservice.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student){
        log.info("Inside addStudent method of studentService");
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student, int id){
        log.info("Inside updateStudent method of studentService");
        Student student1 = new Student();
        try{
            student1 = studentRepository.findById(id)
                    .orElseThrow(() -> new StudentNotFoundException("The Student id " + id + " not found"));
        }
        catch (StudentNotFoundException e){
            e.printStackTrace();
        }

        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setGender(student.getGender());
        student1.setStudentClass(student.getStudentClass());
        student1.setAddress(student.getAddress());
        return  this.studentRepository.save(student1);
    }

    public List<Student> getStudents(){
        log.info("Inside getStudent method of studentService");
        return studentRepository.findAll();
    }

    public Student getStudentById(int id){
        log.info("Inside getStudentById method of studentService");
        return studentRepository.findById(id)
                .orElse(null);
    }

    public ResponseEntity<Student> removeStudent(int id){
        log.info("Inside removeStudent method of studentService");
        Student student = new Student();
        try{
            student = studentRepository.findById(id)
                    .orElseThrow(() -> new StudentNotFoundException("The Student id " + id +" not found"));
        }
        catch (StudentNotFoundException e){
            e.printStackTrace();
        }
        this.studentRepository.delete(student);
        return ResponseEntity.ok().build();
    }
}