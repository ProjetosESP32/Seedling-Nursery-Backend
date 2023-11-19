package com.ifmt.seedlingNursery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.Sensor;
import com.ifmt.seedlingNursery.Repository.SensorRepository;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SensorServiceImpl implements SensorService {
  SensorRepository sensorRepository;

  @Override
  public Sensor saveSensor(Sensor sensor) {
    return sensorRepository.save(sensor);
  }

  @Override
  public Sensor getSensor(Long id) {
    return unwrapSensor(sensorRepository.findById(id), id);
  }

  @Override
  public List<Sensor> getAllSensors() {
    return sensorRepository.findAll();
  }

  @Override
  public void deleteSensor(Long id) {
    sensorRepository.deleteById(id);
  }

  static Sensor unwrapSensor(Optional<Sensor> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, Sensor.class);
  }
}
