package com.examp.studentclassservices.repository;

import com.examp.studentclassservices.entity.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {
}
