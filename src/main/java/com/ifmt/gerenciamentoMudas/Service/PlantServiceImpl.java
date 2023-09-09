package com.ifmt.gerenciamentoMudas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ifmt.gerenciamentoMudas.Model.Plant;
import com.ifmt.gerenciamentoMudas.Model.Specie;
import com.ifmt.gerenciamentoMudas.Repository.PlantRepository;
import com.ifmt.gerenciamentoMudas.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PlantServiceImpl implements PlantService {

  // already being injected because of the constructor
  PlantRepository plantRepository;

  @Override
  public Plant getPlant(Long id) {
    Optional<Plant> plant = plantRepository.findById(id);
    return unwrapPlant(plant, id);
  }

  public Plant savePlant(Plant plant, Long specieId) {
    return plantRepository.save(plant);
  }

  @Override
  public List<Plant> getSpeciePlants(Long specieId) {
    return plantRepository.findBySpecieId(specieId);
  }

  // unwrap
  static Plant unwrapPlant(Optional<Plant> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, Plant.class);
  }

}
