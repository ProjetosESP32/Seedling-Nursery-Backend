package com.sistemasEmbarcados.gerenciamentoMudas.dto;

import lombok.Data;

@Data
public class AcionarValvulaDTO {
    private int tipoAcao; //1 para ligar, 2 para desligar, 3 acionamento geral
    private Long idValvula; // id da valvula a ser desligada
}
