package com.ifmt.seedlingNursery.dto;

import lombok.Data;

@Data
public class SensorDTO {
    private Long idMicrocontrolador;
    private Long idLocalizacao;
    private String tipoSensor;
}