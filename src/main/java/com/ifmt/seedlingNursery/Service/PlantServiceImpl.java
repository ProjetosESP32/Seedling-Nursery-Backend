package com.ifmt.seedlingNursery.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.Plant;
import com.ifmt.seedlingNursery.Model.PlantImages;
import com.ifmt.seedlingNursery.Model.Specie;
import com.ifmt.seedlingNursery.Repository.PlantImagesRepository;
import com.ifmt.seedlingNursery.Repository.PlantRepository;
import com.ifmt.seedlingNursery.Repository.SpecieRepository;
import com.ifmt.seedlingNursery.dto.PlantDto;
import com.ifmt.seedlingNursery.dto.ShelvesPageRow;
import com.ifmt.seedlingNursery.dto.SpeciesPageRow;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PlantServiceImpl implements PlantService {

  // already being injected because of the constructor
  PlantRepository plantRepository;
  SpecieRepository specieRepository;
  PlantImagesRepository plantImagesRepository;

  @Override
  public Plant getPlant(Long id) {
    Optional<Plant> plant = plantRepository.findById(id);
    return unwrapPlant(plant, id);
  }

  /*
   * The controller method below will receive an object that has image and no
   * specie;
   * It will take the image and store it in a separated table;
   * It will search for the specie and store it with the plant record.
   */
  @Override
  public Plant savePlant(PlantDto plantDto, Long specieId) {
    // building the Plant entity
    Specie specie = SpecieServiceImpl.unwrapSpecie(specieRepository.findById(specieId), specieId);
    Plant plant = new Plant();
    BeanUtils.copyProperties(plantDto, plant);
    plant.setSpecie(specie);

    // saving plant
    Plant plant2 = plantRepository.save(plant);

    // getting and saving image
    PlantImages image = new PlantImages(plant2.getId(), plantDto.getImage());
    plantImagesRepository.save(image);

    return plant2;
  }

  @Override
  public List<Plant> getAllPlants() {
    return plantRepository.findAll();
  }

  @Override
  public List<Plant> getSpeciePlants(Long specieId) {
    return plantRepository.findBySpecieId(specieId);
  }

  @Override
  public List<Plant> getPlantsByAddress(String address) {
    return plantRepository.findByAddressLike(address);
  }

  @Override
  public List<Plant> getPlantsByShelf(int shelfId) {
    return plantRepository.findByShelf(shelfId);
  }

  // to populate rows of the interface
  @Override
  public List<SpeciesPageRow> getPlantsByMatrixPage(int index, int pageSize, Long matrixId) {
    List<Plant> plants = plantRepository.findByOriginMatrix(matrixId);
    List<Plant> plantsPage = new ArrayList<>();
    for (int i = index * pageSize; i < (index + 1) * pageSize && i < plants.size(); i++) {
      plantsPage.add(plants.get(i));
    }

    List<SpeciesPageRow> rowObject = new ArrayList<>();
    for (Plant plant : plantsPage) {
      String currentLocation = plant.getAddress().length() > 0 ? plant.getAddress()
          : "Bancada " + Integer.toString(plant.getShelf());
      rowObject.add(new SpeciesPageRow(plant.getId(), plant.getStage(), plant.getPlantingDate(), currentLocation));
    }

    return rowObject;
  }

  @Override
  public List<SpeciesPageRow> getPlantsBySpeciePage(int index, int pageSize, Long specieId, int matrix,
      int seedling, int seed) {

    // plants receives the plants of the selected specie
    List<Plant> plants = plantRepository.findBySpecieId(specieId);

    /*
     * plantsConstrained receives from plants only those that matches the selection
     * (matrix, seedling, seed)
     */
    List<Plant> plantsConstrained = new ArrayList<>();
    for (Plant plant : plants) {
      switch (plant.getStage()) {
        case 0:
          if (matrix > 0) {
            plantsConstrained.add(plant);
          }
          break;
        case 1:
          if (seedling > 0) {
            plantsConstrained.add(plant);
          }
          break;
        case 2:
          if (seed > 0) {
            plantsConstrained.add(plant);
          }
      }
    }

    // plants page receives only <pagesize> records of plants
    List<Plant> plantsPage = new ArrayList<>();
    for (int i = index * pageSize; i < (index + 1) * pageSize && i < plantsConstrained.size(); i++) {
      plantsPage.add(plantsConstrained.get(i));
    }

    /*
     * populates the object rowObject with some datas from the selected plants to
     * display it in the table of plantsBySpecie object in the interface
     */
    List<SpeciesPageRow> rowObject = new ArrayList<>();
    for (Plant plant : plantsPage) {
      String currentLocation = plant.getAddress().length() > 0 ? plant.getAddress()
          : "Bancada " + Integer.toString(plant.getShelf());
      rowObject.add(new SpeciesPageRow(plant.getId(), plant.getStage(), plant.getPlantingDate(), currentLocation));
    }
    return rowObject;
  }

  @Override
  public List<ShelvesPageRow> getPlantsByShelfPage(int index, int pageSize, int shelfId) {
    List<Plant> plants = plantRepository.findByShelf(shelfId);
    List<Plant> plantsPage = new ArrayList<>();
    for (int i = index * pageSize; i < (index + 1) * pageSize && i < plants.size(); i++) {
      plantsPage.add(plants.get(i));
    }

    List<ShelvesPageRow> rows = new ArrayList<>();
    for (Plant plant : plantsPage) {
      ShelvesPageRow row = new ShelvesPageRow(plant.getId(), plant.getOriginMatrix(), plant.getPlantingDate(),
          plant.getSpecie().getName());
      rows.add(row);
    }

    return rows;
  }

  @Override
  public List<SpeciesPageRow> getPlantsByAddressPage(int index, int pageSize, String address) {
    List<Plant> plants = plantRepository.findByAddressLike(address);
    List<Plant> plantsPage = new ArrayList<>();
    for (int i = index * pageSize; i < (index + 1) * pageSize && i < plants.size(); i++) {
      plantsPage.add(plants.get(i));
    }

    List<SpeciesPageRow> rowObject = new ArrayList<>();
    for (Plant plant : plantsPage) {
      String currentLocation = plant.getAddress().length() > 0 ? plant.getAddress()
          : "Bancada " + Integer.toString(plant.getShelf());
      rowObject.add(new SpeciesPageRow(plant.getId(), plant.getStage(), plant.getPlantingDate(), currentLocation));
    }
    return rowObject;
  }

  // row counts
  @Override
  public int getPlantsCount() {
    return plantRepository.getPlantsCount();
  }

  @Override
  public int getPlantsBySpecieCount(Long specieId, int matrix, int seedling, int seed) {
    int matrixCount = 0;
    int seedlingCount = 0;
    int seedCount = 0;

    Specie specie = SpecieServiceImpl.unwrapSpecie(specieRepository.findById(specieId), specieId);

    if (matrix > 0) {
      matrixCount = plantRepository.getPlantsBySpecieCount(0, specie);
    }
    if (seedling > 0) {
      seedlingCount = plantRepository.getPlantsBySpecieCount(1, specie);
    }
    if (seed > 0) {
      seedCount = plantRepository.getPlantsBySpecieCount(2, specie);
    }

    return (matrixCount + seedlingCount + seedCount);
  }

  @Override
  public int getPlantsByShelfCount(int shelf) {
    return plantRepository.getPlantsByShelfCount(shelf);
  }

  @Override
  public int getPlantsByMatrixCount(Long matrixId) {
    return plantRepository.getPlantsByMatrixCount(matrixId);
  }

  @Override
  public int getPlantsByAddressCount(String address) {
    return plantRepository.getByAddressCount(address);
  }

  @Override
  public int[] getPlantsCountByShelf() {
    int shelvesCount[] = new int[10];
    for (int i = 0; i < 10; i++) {
      shelvesCount[i] = plantRepository.getPlantsByShelfCount(i + 1);
    }
    return shelvesCount;
  }

  // unwrap
  static Plant unwrapPlant(Optional<Plant> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, Plant.class);
  }

}
