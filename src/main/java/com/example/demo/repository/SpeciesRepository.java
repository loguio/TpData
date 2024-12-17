package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Species;
import java.util.List;


@Repository
public interface SpeciesRepository extends JpaRepository<Species,Integer>{
   public Species findFirstByCommonName(String commonName);
   public List<Species> findByLatinNameIgnoringCase(String latinName);
}
