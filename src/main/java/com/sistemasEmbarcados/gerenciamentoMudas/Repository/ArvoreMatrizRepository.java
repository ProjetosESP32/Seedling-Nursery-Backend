package com.sistemasEmbarcados.gerenciamentoMudas.Repository;

import com.sistemasEmbarcados.gerenciamentoMudas.Model.Plant;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Semente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArvoreMatrizRepository extends JpaRepository<Plant, Long> {

    @Query("SELECT a.sementeList FROM ArvoreMatriz a WHERE a.id = :id")
    List<Semente> buscarListaSementeApartirIdArvoreMatriz(Long id);
}
