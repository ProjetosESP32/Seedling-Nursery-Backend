package com.ifmt.seedlingNursery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifmt.seedlingNursery.Model.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
