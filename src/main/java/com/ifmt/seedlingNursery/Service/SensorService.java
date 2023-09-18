package com.ifmt.seedlingNursery.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.Sensor;

@Service
public interface SensorService {
  public Sensor saveSensor(Sensor sensor);

  public Sensor getSensor(Long id);

  public List<Sensor> getAllSensors();
}
