package com.example.demo.services;

import com.example.demo.entity.Species;
import com.example.demo.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    // Méthode Create
    public Species createSpecies(Species species) {
        return speciesRepository.save(species);
    }

    // Méthode Update
    public Species updateSpecies(Integer id, Species updatedSpecies) {
        Optional<Species> existingSpecies = speciesRepository.findById(id);
        if (existingSpecies.isPresent()) {
            Species species = existingSpecies.get();
            species.setCommon_name(updatedSpecies.getCommon_name());
            species.setLatin_name(updatedSpecies.getLatin_name());
            return speciesRepository.save(species);
        }
        return null;
    }

    // Passe-plats : récupérer toutes les Species
    public List<Species> getAllSpecies() {
        return speciesRepository.findAll();
    }

    // Passe-plats : récupérer une Species par ID
    public Optional<Species> getSpeciesById(Integer id) {
        return speciesRepository.findById(id);
    }

    // Passe-plats : supprimer une Species par ID
    public void deleteSpeciesById(Integer id) {
        speciesRepository.deleteById(id);
    }
}
