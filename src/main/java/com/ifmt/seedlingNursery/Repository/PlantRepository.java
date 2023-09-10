package com.ifmt.seedlingNursery.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import com.ifmt.seedlingNursery.Model.Plant;

public interface PlantRepository extends JpaRepository<Plant, Long> {
  List<Plant> findBySpecieId(Long specieId);

  @Query("Select a FROM Plant a WHERE a.address LIKE %?1%")
  List<Plant> findByAddressLike(String address);

  List<Plant> findByShelf(int shelf);

  @Query("SELECT COUNT(id) FROM Plant")
  int getPlantsCount();

}
