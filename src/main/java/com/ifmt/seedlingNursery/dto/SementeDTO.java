package com.ifmt.seedlingNursery.dto;

import lombok.Data;

@Data
public class SementeDTO {
    String doencas;
    String contagemFolha;
    String alturaPlanta;
    String observacoes;
    Long idArvoreMatriz;
    Long idSemente;
    String dataPlantio;
    String dataDoacao;
    String imagemSemente;
}
