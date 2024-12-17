package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Species;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Integer>{
    public List<Animal> findBySpecie(Species specie);
    public List<Animal> findByColorIn(List<String> color);

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.sex = :sex")
    Long countBySex(@Param("sex") String sex);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Person p JOIN p.animals a WHERE a = :animal")
    Boolean existsByAnimal(@Param("animal") Animal animal);

}
