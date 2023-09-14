package com.ifmt.seedlingNursery.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShelvesPageRow {
  private Long id;
  private Long idMatriz;
  private LocalDate plantingDate;
  private String specieName;
}
