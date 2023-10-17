package com.ifmt.seedlingNursery.Service;

import java.util.List;

import com.ifmt.seedlingNursery.Model.IrrigationTime;

public interface IrrigationTimeService {
  public IrrigationTime getTime(Long id);

  public IrrigationTime saveTime(IrrigationTime irrigationTime, Long valveId);

  public List<IrrigationTime> getTimesByValve(Long valveId);

  public Boolean isValveOn(Long valveId);
}
