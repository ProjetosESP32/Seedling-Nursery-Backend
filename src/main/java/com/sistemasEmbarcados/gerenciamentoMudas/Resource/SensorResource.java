package com.sistemasEmbarcados.gerenciamentoMudas.Resource;

import com.google.gson.Gson;
//import com.sistemasEmbarcados.gerenciamentoMudas.Gateway.MqttGateway;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.ArvoreMatriz;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Localizacao;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.ValorSensor;
import com.sistemasEmbarcados.gerenciamentoMudas.Service.SensorService;
import com.sistemasEmbarcados.gerenciamentoMudas.dto.AcionarValvulaDTO;
import com.sistemasEmbarcados.gerenciamentoMudas.dto.SensorDTO;
import com.sistemasEmbarcados.gerenciamentoMudas.dto.ValorSensorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensor")
public class SensorResource {

}
