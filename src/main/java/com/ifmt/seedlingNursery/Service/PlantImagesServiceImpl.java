package com.ifmt.seedlingNursery.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.PlantImages;
import com.ifmt.seedlingNursery.Repository.PlantImagesRepository;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PlantImagesServiceImpl implements PlantImagesService {
  PlantImagesRepository plantImagesRepository;

  public PlantImages save(PlantImages plantImages) {
    return plantImagesRepository.save(plantImages);
  }

  public PlantImages getByID(Long id) {
    return unwrapPlantImages(plantImagesRepository.findById(id), id);
  }

  static PlantImages unwrapPlantImages(Optional<PlantImages> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, PlantImages.class);
  }

}
