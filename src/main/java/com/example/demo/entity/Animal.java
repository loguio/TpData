package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "animal") 
public class Animal {
    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(50)", nullable = true) 
    private String color;
   
    @Column(columnDefinition = "varchar(50)", nullable = false) 
    private String name;
    
    @Column(columnDefinition = "varchar(255)", nullable = false) 
    private String sex;

    private Species specie;

    @ManyToMany
    private Set<Person> persons;
}
