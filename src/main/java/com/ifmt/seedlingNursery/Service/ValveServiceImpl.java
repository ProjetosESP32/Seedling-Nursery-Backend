package com.ifmt.seedlingNursery.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.IrrigationTime;
import com.ifmt.seedlingNursery.Model.Valve;
import com.ifmt.seedlingNursery.Repository.IrrigationTimeRepository;
import com.ifmt.seedlingNursery.Repository.ValveRepository;
import com.ifmt.seedlingNursery.dto.ValvesStateDto;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ValveServiceImpl implements ValveService {

  // beans
  ValveRepository valveRepository;
  IrrigationTimeRepository irrigationTimeRepository;
  IrrigationTimeService irrigationTimeService;

  @Override
  public Valve saveValve(Valve valve) {
    valve.setCurrentState(false);
    return valveRepository.save(valve);
  }

  @Override
  public Valve getValve(Long id) {
    Valve valve = unwrapValve(valveRepository.findById(id), id);
    valve.setCurrentState(irrigationTimeService.isValveOn(valve.getId()));
    return valve;
  }

  @Override
  public List<Valve> getAllValves() {
    List<Valve> valves = valveRepository.findAll();

    for (int i = 0; i < valves.size(); i++) {
      System.out.println(valves.get(i).getId());
      valves.get(i).setCurrentState(irrigationTimeService.isValveOn(valves.get(i).getId()));
    }

    return valveRepository.findAll();
  };

  @Override
  public List<Valve> getValvesByShelf(int shelf) {
    return valveRepository.findByShelf(shelf);
  }

  @Override
  public List<ValvesStateDto> getValvesStates() {
    List<Valve> valves = valveRepository.findAll();
    List<ValvesStateDto> states = new ArrayList<>();
    for (Valve valve : valves) {
      List<IrrigationTime> irrigationTimeList = irrigationTimeService.getTimesByValve(valve.getId());
      List<LocalTime> localTimeList = new ArrayList<>();
      for (IrrigationTime irrigationTime : irrigationTimeList) {
        localTimeList.add(irrigationTime.getInitialTime());
      }

      states.add(new ValvesStateDto(valve.getId(), irrigationTimeService.isValveOn(valve.getId()), localTimeList));
    }
    return states;
  }

  @Override
  @Transactional
  public void deleteValve(Long id) {
    irrigationTimeRepository.deleteByValve(unwrapValve(valveRepository.findById(id), id));
    valveRepository.deleteById(id);
  }

  static Valve unwrapValve(Optional<Valve> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, Valve.class);
  }
}
