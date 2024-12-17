package com.example.demo.controller;

import com.example.demo.entity.Species;
import com.example.demo.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;

    // Create
    @PostMapping
    public Species createSpecies(@RequestBody Species species) {
        return speciesService.createSpecies(species);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Species> updateSpecies(@PathVariable Integer id, @RequestBody Species species) {
        Species updatedSpecies = speciesService.updateSpecies(id, species);
        if (updatedSpecies != null) {
            return ResponseEntity.ok(updatedSpecies);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecies(@PathVariable Integer id) {
        speciesService.deleteSpeciesById(id);
        return ResponseEntity.noContent().build();
    }

    // FindAll
    @GetMapping
    public List<Species> getAllSpecies() {
        return speciesService.getAllSpecies();
    }

    // FindById
    @GetMapping("/{id}")
    public ResponseEntity<Species> getSpeciesById(@PathVariable Integer id) {
        Optional<Species> species = speciesService.getSpeciesById(id);
        return species.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
