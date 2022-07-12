package com.examp.studentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class StudentClass {
    @Id
    @SequenceGenerator(
            name = "student_class_sequence",
            sequenceName = "student_class_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_class_sequence"
    )
    private int student_class_id;
    private int standard;

    @OneToMany(targetEntity = Subject.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "student_class_id", referencedColumnName = "student_class_id")

    private List<Subject> subjects;
}