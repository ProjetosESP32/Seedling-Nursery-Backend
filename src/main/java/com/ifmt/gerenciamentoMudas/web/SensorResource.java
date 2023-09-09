package com.ifmt.gerenciamentoMudas.web;

import com.google.gson.Gson;
import com.ifmt.gerenciamentoMudas.Model.Localizacao;
import com.ifmt.gerenciamentoMudas.Model.Plant;
import com.ifmt.gerenciamentoMudas.Model.ValorSensor;
import com.ifmt.gerenciamentoMudas.Service.SensorService;
import com.ifmt.gerenciamentoMudas.dto.AcionarValvulaDTO;
import com.ifmt.gerenciamentoMudas.dto.SensorDTO;
import com.ifmt.gerenciamentoMudas.dto.ValorSensorDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensor")
public class SensorResource {

}
