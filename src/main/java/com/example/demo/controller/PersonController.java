package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    // Create
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person person) {
        Person updatedPerson = personService.updatePerson(id, person);
        if (updatedPerson != null) {
            return ResponseEntity.ok(updatedPerson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        personService.deletePersonById(id);
        return ResponseEntity.noContent().build();
    }

    // FindAll
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    // FindById
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Integer id) {
        Optional<Person> person = personService.getPersonById(id);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

     @GetMapping("/paginated")
    public Page<Person> getPaginatedPersons(
            @RequestParam(defaultValue = "0") int page,  // Page numéro 0 par défaut
            @RequestParam(defaultValue = "10") int size // Taille de 10 par défaut
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return personService.getAllPersonsPaginated(pageable);
    }
}
