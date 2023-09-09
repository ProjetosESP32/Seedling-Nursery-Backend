package com.ifmt.gerenciamentoMudas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifmt.gerenciamentoMudas.Model.Specie;
import com.ifmt.gerenciamentoMudas.Model.Plant;

@Repository
public interface SpecieRepository extends JpaRepository<Specie, Long> {
}
