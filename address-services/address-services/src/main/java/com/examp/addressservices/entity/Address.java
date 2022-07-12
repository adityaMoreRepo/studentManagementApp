package com.examp.addressservices.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "address",
        uniqueConstraints = @UniqueConstraint(
                name = "mobileNo_unique",
                columnNames = "mobile_no"
        )
)
@Builder
public class Address {

    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private int address_id;

    @Column(
            nullable = false
    )
    private int flat_no;

    @Column(
            nullable = false
    )
    private String road;

    @Column(
            nullable = false
    )
    private String city;

    @Column(
            nullable = false
    )
    private String state;

    @Column(
            nullable = false
    )
    private String pin;

    @Column(
            name = "mobile_no",
            nullable = false
    )
    private String mobile_no;
}
