package com.ifmt.seedlingNursery.Service;

import java.util.List;

import com.ifmt.seedlingNursery.Model.Specie;

public interface SpecieService {
  public Specie getSpecie(Long id);

  public Specie saveSpecie(Specie specie);

  public List<Specie> getAllSpecies();

  public List<Specie> get7Species(int num);
}
