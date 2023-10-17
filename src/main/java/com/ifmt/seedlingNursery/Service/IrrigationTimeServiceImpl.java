package com.ifmt.seedlingNursery.Service;

import java.time.LocalTime;
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
    List<IrrigationTime> times = irrigationTimeRepository.findByValveId(valveId);
    for (IrrigationTime time : times) {
      // if irrigation time does't pass through midnight
      if (time.getInitialTime().compareTo(time.getFinalTime()) < 0) {
        if (time.getInitialTime().compareTo(LocalTime.now()) < 0
            && time.getFinalTime().compareTo(LocalTime.now()) > 0)
          return true;

        // if the irrigation time passes through midnight
      } else {
        if (time.getInitialTime().compareTo(LocalTime.now()) < 0 || time.getFinalTime().compareTo(LocalTime.now()) > 0)
          return true;
      }

    }

    // if it does't match any of the above condition, the valve must be off
    return false;
  }

  static IrrigationTime unwrapTime(Optional<IrrigationTime> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, IrrigationTime.class);
  }

}
