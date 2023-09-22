package com.ifmt.seedlingNursery.Service;

import com.ifmt.seedlingNursery.Model.SpecieImages;

public interface SpecieImagesService {
  public SpecieImages saveSpecieImage(SpecieImages image);

  public SpecieImages getSpecieImage(Long id);
}
