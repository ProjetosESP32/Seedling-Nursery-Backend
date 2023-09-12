package com.ifmt.seedlingNursery.Service;

import java.util.List;

import com.ifmt.seedlingNursery.Model.Plant;
import com.ifmt.seedlingNursery.dto.SpeciesPageRow;

public interface PlantService {
  public Plant getPlant(Long id);

  public Plant savePlant(Plant plant, Long specieId);

  public List<Plant> getAllPlants();

  public List<Plant> getSpeciePlants(Long specieId);

  public List<Plant> getPlantsByAddress(String address);

  public List<Plant> getPlantsByShelf(int shelfId);

  public List<SpeciesPageRow> getPlantsPerSpeciePage(int index, int pageSize, Long specieId, int matrix,
      int seedling,
      int seed);

  public int getPlantsCount();

  public int getPlantsBySpecieCount(Long specie, int matrix, int seedling, int seed);
}
