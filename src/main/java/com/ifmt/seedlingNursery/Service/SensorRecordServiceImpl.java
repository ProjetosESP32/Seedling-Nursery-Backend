package com.ifmt.seedlingNursery.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.Sensor;
import com.ifmt.seedlingNursery.Model.SensorRecord;
import com.ifmt.seedlingNursery.Repository.SensorRecordRepository;
import com.ifmt.seedlingNursery.Repository.SensorRepository;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SensorRecordServiceImpl implements SensorRecordService {
  SensorRecordRepository sensorRecordRepository;
  SensorRepository sensorRepository;

  @Override
  public SensorRecord saveSensorRecord(SensorRecord sensorRecord, Long sensorId) {
    Sensor sensor = SensorServiceImpl.unwrapSensor(sensorRepository.findById(sensorId), sensorId);
    sensorRecord.setSensor(sensor);
    sensorRecord.setTimeStamp(LocalDateTime.now());
    return sensorRecordRepository.save(sensorRecord);
  }

  @Override
  public SensorRecord getSensorRecord(Long id) {
    return unwrapSensorRecord(sensorRecordRepository.findById(id), id);
  }

  @Override
  public List<SensorRecord> getAllSensorRecord() {
    return sensorRecordRepository.findAll();
  }

  @Override
  public List<SensorRecord> getAllBySensor(Long sensorId, LocalDateTime time1, LocalDateTime time2) {
    Sensor sensor = SensorServiceImpl.unwrapSensor(sensorRepository.findById(sensorId), sensorId);
    return sensorRecordRepository.findBySensor(sensor, time1, time2);
  }

  @Override
  public List<SensorRecord> getAllBetweenTimes(LocalDateTime time1, LocalDateTime time2) {
    return sensorRecordRepository.findREcordBetweenTimes(time1, time2);
  }

  static SensorRecord unwrapSensorRecord(Optional<SensorRecord> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, SensorRecord.class);
  }

}
