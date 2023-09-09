package com.ifmt.seedlingNursery.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.ifmt.seedlingNursery.Model.Plant;

public interface PlantRepository extends JpaRepository<Plant, Long> {
  List<Plant> findBySpecieId(Long specieId);
}
