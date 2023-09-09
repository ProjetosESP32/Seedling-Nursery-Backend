package com.ifmt.seedlingNursery.web;

import com.google.gson.Gson;
import com.ifmt.seedlingNursery.Model.Localizacao;
import com.ifmt.seedlingNursery.Model.Plant;
import com.ifmt.seedlingNursery.Model.ValorSensor;
import com.ifmt.seedlingNursery.Service.SensorService;
import com.ifmt.seedlingNursery.dto.AcionarValvulaDTO;
import com.ifmt.seedlingNursery.dto.SensorDTO;
import com.ifmt.seedlingNursery.dto.ValorSensorDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensor")
public class SensorResource {

}
