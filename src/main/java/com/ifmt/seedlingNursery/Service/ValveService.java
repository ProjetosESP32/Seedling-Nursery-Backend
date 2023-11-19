package com.ifmt.seedlingNursery.Service;

import java.util.List;

import com.ifmt.seedlingNursery.Model.Valve;
import com.ifmt.seedlingNursery.dto.ValvesStateDto;

public interface ValveService {
  public Valve saveValve(Valve valve);

  public Valve getValve(Long id);

  public List<Valve> getAllValves();

  public List<Valve> getValvesByShelf(int shelf);

  public List<ValvesStateDto> getValvesStates();

  public void deleteValve(Long id);

}
