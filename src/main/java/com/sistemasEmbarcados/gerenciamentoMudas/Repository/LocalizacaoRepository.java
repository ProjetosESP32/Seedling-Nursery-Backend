package com.sistemasEmbarcados.gerenciamentoMudas.Repository;

import com.sistemasEmbarcados.gerenciamentoMudas.Model.ArvoreMatriz;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Localizacao;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.MicroControlador;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Semente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {

    @Query("SELECT a.microControladorList FROM Localizacao a WHERE a.id = :id")
    List<MicroControlador> buscarListaMicroControladorApartirIdLocalizacao(Long id);

    @Query("SELECT a.sementeList FROM Localizacao a WHERE a.id = :id")
    List<Semente> buscarSementeApartirIdLocalizacao(Long id);
}
