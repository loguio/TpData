package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Species;
import java.util.List;


@Repository
public interface SpeciesRepository extends JpaRepository<Species,Integer>{
   public Species findFirstByCommonName(String commonName);
   public List<Species> findByLatinNameIgnoringCase(String latinName);

   @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllOrderByCommonNameAsc();   

    @Query("SELECT s FROM Species s WHERE s.commonName LIKE %:name%")
    List<Species> findByCommonNameLike(@Param("name") String name);
}
