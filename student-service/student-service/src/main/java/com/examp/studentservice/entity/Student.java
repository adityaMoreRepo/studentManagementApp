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
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private int student_id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    private String gender;

    @OneToOne(targetEntity = Address.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
            //optional = false
    )
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;


    @ManyToOne(targetEntity = StudentClass.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER // this will include this attribute while fetching
            // the parent table here Student entity
            // while lazy won't fetch it
            // by default it is optional relationship and not mandatory
            // that is for studentClass student is optional if it's bidirectional
            // or for Student entity we don't need studentClass mandatory if as follows
            //optional = false
    )
    @JoinColumn(name = "student_class_id", referencedColumnName = "student_class_id")
    private StudentClass studentClass;
}
