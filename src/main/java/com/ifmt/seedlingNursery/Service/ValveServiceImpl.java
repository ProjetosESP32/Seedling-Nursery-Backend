package com.ifmt.seedlingNursery.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.Valve;
import com.ifmt.seedlingNursery.Repository.ValveRepository;
import com.ifmt.seedlingNursery.dto.ValvesStateDto;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ValveServiceImpl implements ValveService {
  ValveRepository valveRepository;
  IrrigationTimeService irrigationTimeService;

  @Override
  public Valve saveValve(Valve valve) {
    valve.setCurrentState(false);
    return valveRepository.save(valve);
  }

  @Override
  public Valve getValve(Long id) {
    return unwrapValve(valveRepository.findById(id), id);
  }

  @Override
  public List<Valve> getAllValves() {
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
      states.add(new ValvesStateDto(valve.getId(), irrigationTimeService.isValveOn(valve.getId())));
    }
    return states;
  }

  static Valve unwrapValve(Optional<Valve> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, Valve.class);
  }
}
