package com.ifmt.gerenciamentoMudas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.ifmt.gerenciamentoMudas.Model.Plant;

public interface PlantRepository extends JpaRepository<Plant, Long> {
  List<Plant> findBySpecieId(Long specieId);
}
