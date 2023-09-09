package com.ifmt.seedlingNursery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.Plant;
import com.ifmt.seedlingNursery.Model.Specie;
import com.ifmt.seedlingNursery.Repository.PlantRepository;
import com.ifmt.seedlingNursery.Repository.SpecieRepository;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PlantServiceImpl implements PlantService {

  // already being injected because of the constructor
  PlantRepository plantRepository;
  SpecieRepository specieRepository;

  @Override
  public Plant getPlant(Long id) {
    Optional<Plant> plant = plantRepository.findById(id);
    return unwrapPlant(plant, id);
  }

  @Override
  public Plant savePlant(Plant plant, Long specieId) {
    Specie specie = SpecieServiceImpl.unwrapSpecie(specieRepository.findById(specieId), specieId);
    plant.setSpecie(specie);
    return plantRepository.save(plant);
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

  // unwrap
  static Plant unwrapPlant(Optional<Plant> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, Plant.class);
  }

}
