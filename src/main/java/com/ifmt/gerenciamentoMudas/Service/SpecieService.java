package com.ifmt.gerenciamentoMudas.Service;

import java.util.List;

import com.ifmt.gerenciamentoMudas.Model.Specie;

public interface SpecieService {
  public Specie getSpecie(Long id);

  public Specie saveSpecie(Specie specie);

  public List<Specie> getAllSpecies();

}
