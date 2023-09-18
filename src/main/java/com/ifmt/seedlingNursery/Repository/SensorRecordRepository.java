package com.ifmt.seedlingNursery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifmt.seedlingNursery.Model.Sensor;
import com.ifmt.seedlingNursery.Model.SensorRecord;
import java.util.List;

public interface SensorRecordRepository extends JpaRepository<SensorRecord, Long> {
  List<SensorRecord> findBySensor(Sensor sensor);
}
