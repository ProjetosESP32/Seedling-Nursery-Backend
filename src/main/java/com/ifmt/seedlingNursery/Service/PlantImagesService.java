package com.ifmt.seedlingNursery.Service;

import com.ifmt.seedlingNursery.Model.PlantImages;

public interface PlantImagesService {
  public PlantImages save(PlantImages plantImages);

  public PlantImages getByID(Long id);
}
