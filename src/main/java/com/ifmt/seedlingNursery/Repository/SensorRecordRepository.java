package com.ifmt.seedlingNursery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifmt.seedlingNursery.Model.Sensor;
import com.ifmt.seedlingNursery.Model.SensorRecord;

import java.time.LocalDateTime;
import java.util.List;

public interface SensorRecordRepository extends JpaRepository<SensorRecord, Long> {
  @Query("SELECT a FROM SensorRecord a WHERE sensor=:sensor AND a.timeStamp BETWEEN :time1 AND :time2 ORDER BY a.timeStamp DESC")
  List<SensorRecord> findBySensor(Sensor sensor, LocalDateTime time1, LocalDateTime time2);

  @Query("SELECT a FROM SensorRecord a WHERE a.timeStamp BETWEEN :time1 AND :time2")
  List<SensorRecord> findREcordBetweenTimes(LocalDateTime time1, LocalDateTime time2);

  // List<SensorRecord> saveAll(List<SensorRecord> records);

  /* @Query("DELETE FROM SensorRecord a WHERE a.sensor=:sensor") */
  Long deleteBySensor(Sensor sensor);
}
