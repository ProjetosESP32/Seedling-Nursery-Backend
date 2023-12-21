package com.ifmt.seedlingNursery.dto;

import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValvesStateDto {
  private Long id;
  private Boolean state;
  private List<LocalTime> initialTime;
}
