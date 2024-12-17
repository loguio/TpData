package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "person") 
public class Person {
    @Id
    private Integer id;

    private Integer age;

    private String firstName;

    private String lastName;

    @ManyToMany
    private Set<Animal> animals;
}
