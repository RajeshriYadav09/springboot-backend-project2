package com.techcushy.springbootbackendproject2.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="lastName",nullable=false)
    private String lastName;
    @Column(name="firstName", nullable = false)
    private String firstName;
    @Column(name="email")
    private String email;
   
}
