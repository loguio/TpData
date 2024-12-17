package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>{
    
    @Query("SELECT p FROM Person p where p.lastName = ?1 or p.firstName = ?2")
    public List<Person> findByFirstNameorLastName(String LastName, String firstName);

    @Query("SELECT p from Person p where p.age >= ?1")
    public List<Person> findByAge(int age);
}
