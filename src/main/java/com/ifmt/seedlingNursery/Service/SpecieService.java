package com.ifmt.seedlingNursery.Service;

import java.util.List;

import com.ifmt.seedlingNursery.Model.Specie;
import com.ifmt.seedlingNursery.dto.SpecieDto;

public interface SpecieService {
  public Specie getSpecie(Long id);

  public Specie saveSpecie(SpecieDto specieDto);

  public List<Specie> getAllSpecies();

  public List<Specie> get7Species(int num);
}
