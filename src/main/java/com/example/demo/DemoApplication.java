package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.AnimalRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.SpeciesRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private SpeciesRepository speciesRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		throw new UnsupportedOperationException("Unimplemented method 'run'");
	}

}
