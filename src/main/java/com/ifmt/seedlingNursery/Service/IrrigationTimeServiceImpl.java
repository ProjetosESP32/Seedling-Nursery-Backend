package com.ifmt.seedlingNursery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.IrrigationTime;
import com.ifmt.seedlingNursery.Model.Valve;
import com.ifmt.seedlingNursery.Repository.IrrigationTimeRepository;
import com.ifmt.seedlingNursery.Repository.ValveRepository;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class IrrigationTimeServiceImpl implements IrrigationTimeService {

  IrrigationTimeRepository irrigationTimeRepository;
  ValveRepository valveRepository;

  public IrrigationTime getTime(Long id) {
    return unwrapTime(irrigationTimeRepository.findById(id), id);
  }

  public IrrigationTime saveTime(IrrigationTime irrigationTime, Long valveId) {
    Valve valve = ValveServiceImpl.unwrapValve(valveRepository.findById(valveId), valveId);
    irrigationTime.setValve(valve);
    return irrigationTimeRepository.save(irrigationTime);
  }

  public List<IrrigationTime> getTimesByValve(Long valveId) {
    return irrigationTimeRepository.findByValveId(valveId);
  }

  // needs to be implemented...
  public Boolean isValveOn(Long valveId) {
    return true;
  }

  static IrrigationTime unwrapTime(Optional<IrrigationTime> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, IrrigationTime.class);
  }

}
