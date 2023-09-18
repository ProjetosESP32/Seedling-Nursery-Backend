package com.ifmt.seedlingNursery.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifmt.seedlingNursery.Model.Sensor;
import com.ifmt.seedlingNursery.Service.SensorService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/sensor")
public class SensorController {
  SensorService sensorService;

  @PostMapping
  public ResponseEntity<Sensor> saveSensor(@RequestBody Sensor sensor) {
    return new ResponseEntity<>(sensorService.saveSensor(sensor), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Sensor> getSensor(@PathVariable Long id) {
    return new ResponseEntity<Sensor>(sensorService.getSensor(id), HttpStatus.OK);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Sensor>> getAllSensors() {
    return new ResponseEntity<List<Sensor>>(sensorService.getAllSensors(), HttpStatus.OK);
  }
}
