package com.ifmt.seedlingNursery.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimePeriodDto {
  private LocalDateTime time1;
  private LocalDateTime time2;

}
