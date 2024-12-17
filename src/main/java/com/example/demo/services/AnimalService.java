package com.example.demo.services;

import com.example.demo.entity.Animal;
import com.example.demo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    // Méthode Create
    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    // Méthode Update
    public Animal updateAnimal(Integer id, Animal updatedAnimal) {
        Optional<Animal> existingAnimal = animalRepository.findById(id);
        if (existingAnimal.isPresent()) {
            Animal animal = existingAnimal.get();
            animal.setName(updatedAnimal.getName());
            animal.setColor(updatedAnimal.getColor());
            animal.setSex(updatedAnimal.getSex());
            return animalRepository.save(animal);
        }
        return null;
    }

    // Passe-plats : récupérer tous les Animal
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    // Passe-plats : récupérer un Animal par ID
    public Optional<Animal> getAnimalById(Integer id) {
        return animalRepository.findById(id);
    }

    // Passe-plats : supprimer un Animal par ID
    public void deleteAnimalById(Integer id) {
        animalRepository.deleteById(id);
    }
}
    