package com.ifmt.seedlingNursery.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifmt.seedlingNursery.Model.Plant;
import com.ifmt.seedlingNursery.Model.Specie;

public interface PlantRepository extends JpaRepository<Plant, Long> {
  List<Plant> findBySpecieId(Long specieId);

  @Query("Select a FROM Plant a WHERE UPPER(a.address) LIKE UPPER(concat('%', ?1, '%'))")
  List<Plant> findByAddressLike(String address);

  List<Plant> findByShelf(int shelf);

  List<Plant> findByOriginMatrix(Long originMatrix);

  @Query("SELECT COUNT(id) FROM Plant")
  int getPlantsCount();

  @Query("SELECT COUNT(*) FROM Plant WHERE stage=:stage AND specie=:specie")
  int getPlantsBySpecieCount(int stage, Specie specie);

  @Query("SELECT COUNT(*) FROM Plant WHERE shelf=:shelf")
  int getPlantsByShelfCount(int shelf);

  @Query("SELECT COUNT(*) FROM Plant WHERE originMatrix=:matrix")
  int getPlantsByMatrixCount(Long matrix);

  @Query("Select COUNT(*) FROM Plant a WHERE a.address LIKE %?1%")
  int getByAddressCount(String address);
}
