package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "species") 
public class Species {
    
    @Id
    private Integer id;

    private String common_name;
    
    private String latin_name;
}
