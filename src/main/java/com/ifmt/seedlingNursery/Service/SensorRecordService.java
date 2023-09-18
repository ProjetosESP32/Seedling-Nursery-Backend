package com.ifmt.seedlingNursery.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.SensorRecord;

@Service
public interface SensorRecordService {
  public SensorRecord saveSensorRecord(SensorRecord sensorRecord, Long sensorId);

  public SensorRecord getSensorRecord(Long id);

  public List<SensorRecord> getAllSensorRecord();

  public List<SensorRecord> getAllBySensor(Long sensorId, LocalDateTime time1, LocalDateTime time2);

  public List<SensorRecord> getAllBetweenTimes(LocalDateTime time1, LocalDateTime time2);
}
