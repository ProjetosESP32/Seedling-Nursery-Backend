package com.ifmt.seedlingNursery.Service;

import java.util.List;

import com.ifmt.seedlingNursery.Model.Plant;
import com.ifmt.seedlingNursery.dto.PlantDto;
import com.ifmt.seedlingNursery.dto.ShelvesPageRow;
import com.ifmt.seedlingNursery.dto.SpeciesPageRow;

public interface PlantService {
  public Plant getPlant(Long id);

  public List<Plant> savePlant(PlantDto plantDto, Long specieId, int number);

  public List<Plant> getAllPlants();

  public List<Plant> getSpeciePlants(Long specieId);

  public List<Plant> getPlantsByAddress(String address);

  public List<Plant> getPlantsByShelf(int shelfId);

  // pages table rows

  public List<SpeciesPageRow> getPlantsByMatrixPage(int index, int pageSize, Long matrixId);

  public List<SpeciesPageRow> getPlantsBySpeciePage(int index, int pageSize, Long specieId, int matrix,
      int seedling,
      int seed);

  public List<ShelvesPageRow> getPlantsByShelfPage(int index, int pageSize, int shelfId);

  public List<SpeciesPageRow> getPlantsByAddressPage(int index, int pageSize, String address);

  // rows count

  public int getPlantsCount();

  public int getPlantsBySpecieCount(Long specie, int matrix, int seedling, int seed);

  public int getPlantsByShelfCount(int shelf);

  public int getPlantsByMatrixCount(Long matrixId);

  public int getPlantsByAddressCount(String address);

  public int[] getPlantsCountByShelf();

}
