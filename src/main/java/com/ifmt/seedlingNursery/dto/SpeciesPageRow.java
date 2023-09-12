package com.ifmt.seedlingNursery.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* 
 * The POJO of this class will be used to generate the rows that will be displayed in the PlantsBySpecie component of the web interface
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpeciesPageRow {
  private Long id;
  private int stage;
  private LocalDate plantingDate;
  private String currentLocation;
}
