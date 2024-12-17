package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>,PersonRepositoryCustom {
    Page<Person> findAll(Pageable pageable);

    public List<Person> findByFirstNameorLastName(String LastName, String firstName);

    public List<Person> findByAgeGreaterThanEqual(Integer age);

    @Query("SELECT p FROM Person p WHERE p.age BETWEEN :minAge AND :maxAge")
    List<Person> findByAgeBetween(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);

    @Query("SELECT p FROM Person p JOIN p.animals a WHERE a = :animal")
    List<Person> findByAnimal(@Param("animal") Animal animal);

}
