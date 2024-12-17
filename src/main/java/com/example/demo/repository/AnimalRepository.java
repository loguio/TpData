package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Species;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Integer>{
    public List<Animal> findBySpecie(Species specie);
    public List<Animal> findByColorIn(List<String> color);
    
}
