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
import com.ifmt.seedlingNursery.Model.SensorRecord;
import com.ifmt.seedlingNursery.Service.SensorRecordService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/sensor-record")
public class SensorRecordController {
  SensorRecordService sensorRecordService;

  @PostMapping("/{sensorId}")
  public ResponseEntity<SensorRecord> saveSensorRecord(@RequestBody SensorRecord sensorRecord,
      @PathVariable Long sensorId) {
    return new ResponseEntity<SensorRecord>(sensorRecordService.saveSensorRecord(sensorRecord, sensorId),
        HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<SensorRecord> getSensorRecord(@PathVariable Long id) {
    return new ResponseEntity<SensorRecord>(sensorRecordService.getSensorRecord(id), HttpStatus.OK);
  }

  @GetMapping("/all")
  public ResponseEntity<List<SensorRecord>> getAllSensorRecords() {
    return new ResponseEntity<List<SensorRecord>>(sensorRecordService.getAllSensorRecord(), HttpStatus.OK);
  }

  @GetMapping("/sensor/{sensorId}")
  public ResponseEntity<List<SensorRecord>> getAllBySensor(@PathVariable Long sensorId) {
    return new ResponseEntity<List<SensorRecord>>(sensorRecordService.getAllBySensor(sensorId), HttpStatus.OK);
  }

}
