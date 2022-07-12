package com.examp.studentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Subject {
    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )
    private int subject_id;
    private String sub_name;
    private int total_marks;
    private int marks_obtained;
    private int passing_marks;

    // we can also create many to one relationship here
//    @ManyToOne(cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER
//    )
//    @JoinColumn(name = "student_class_id",
//            referencedColumnName = "student_class_id"
//    )
//    private StudentClass StudentClass;
}
