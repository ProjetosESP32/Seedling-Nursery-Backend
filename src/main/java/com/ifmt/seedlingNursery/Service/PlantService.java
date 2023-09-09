package com.ifmt.seedlingNursery.Service;

import java.util.List;

import com.ifmt.seedlingNursery.Model.Plant;

public interface PlantService {
  public Plant getPlant(Long id);

  public Plant savePlant(Plant plant, Long specieId);

  public List<Plant> getSpeciePlants(Long specieId);

}
