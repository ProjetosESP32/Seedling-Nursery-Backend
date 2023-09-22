package com.ifmt.seedlingNursery.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.SpecieImages;
import com.ifmt.seedlingNursery.Repository.SpecieImagesRepository;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SpecieImagesServiceImpl implements SpecieImagesService {
  SpecieImagesRepository specieImagesRepository;

  @Override
  public SpecieImages saveSpecieImage(SpecieImages image) {
    return specieImagesRepository.save(image);
  }

  @Override
  public SpecieImages getSpecieImage(Long id) {
    return unwrapSpecieImages(specieImagesRepository.findById(id), id);
  }

  static SpecieImages unwrapSpecieImages(Optional<SpecieImages> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, SpecieImages.class);
  }
}
