package com.example.demo.services;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    // Méthode Create
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    // Méthode Update
    public Person updatePerson(Integer id, Person updatedPerson) {
        Optional<Person> existingPerson = personRepository.findById(id);
        if (existingPerson.isPresent()) {
            Person person = existingPerson.get();
            person.setAge(updatedPerson.getAge());
            person.setFirstName(updatedPerson.getFirstName());
            person.setLastName(updatedPerson.getLastName());
            return personRepository.save(person);
        }
        return null;
    }

    // Passe-plats : récupérer tous les Person
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // Passe-plats : récupérer un Person par ID
    public Optional<Person> getPersonById(Integer id) {
        return personRepository.findById(id);
    }

    // Passe-plats : supprimer un Person par ID
    public void deletePersonById(Integer id) {
        personRepository.deleteById(id);
    }

    public Page<Person> getAllPersonsPaginated(Pageable pageable) {
        return personRepository.findAll(pageable);
    }
}
