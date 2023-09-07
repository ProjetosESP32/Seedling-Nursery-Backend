package com.sistemasEmbarcados.gerenciamentoMudas.Repository;

import com.sistemasEmbarcados.gerenciamentoMudas.Model.ArvoreMatriz;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Semente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SementeRepository extends JpaRepository<Semente, Long> {
}
