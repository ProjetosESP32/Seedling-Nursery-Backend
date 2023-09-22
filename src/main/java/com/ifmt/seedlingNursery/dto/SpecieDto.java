package com.ifmt.seedlingNursery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecieDto {
  private Long id;
  private String name;
  private String scienName;
  private String description;
  private byte[] image;
}
