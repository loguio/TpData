package com.example.demo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

import java.util.Random;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void deletePersonsWithoutAnimals() {
        entityManager.createQuery(
            "DELETE FROM Person p WHERE p.animals IS EMPTY"
        ).executeUpdate();
    }

    @Override
    @Transactional
    public void generateRandomPersons(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Person person = new Person();
            person.setFirstName("FirstName" + random.nextInt(1000));
            person.setLastName("LastName" + random.nextInt(1000));
            person.setAge(random.nextInt(90) + 1); // Age entre 1 et 90
            entityManager.persist(person);
        }
    }
}
