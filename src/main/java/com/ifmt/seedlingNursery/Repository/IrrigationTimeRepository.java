package com.ifmt.seedlingNursery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifmt.seedlingNursery.Model.IrrigationTime;

import java.util.List;

public interface IrrigationTimeRepository extends JpaRepository<IrrigationTime, Long> {
  List<IrrigationTime> findByValveId(Long valveId);
}
