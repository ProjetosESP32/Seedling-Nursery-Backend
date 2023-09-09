package com.ifmt.gerenciamentoMudas.Service;

import java.util.List;

import com.ifmt.gerenciamentoMudas.Model.Plant;

public interface PlantService {
  public Plant getPlant(Long id);

  public Plant savePlant(Plant plant, Long specieId);

  public List<Plant> getSpeciePlants(Long specieId);

}
