package com.ifmt.seedlingNursery.dto;

import lombok.Data;

@Data
public class ValorSensorDTO {
    private Long idMicrocontrolador;
    private Long idLocalizacao;
    private Long idSensor;
    private String valorSensor;
}
