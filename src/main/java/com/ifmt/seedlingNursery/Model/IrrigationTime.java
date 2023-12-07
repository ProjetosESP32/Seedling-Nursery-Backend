package com.ifmt.seedlingNursery.Model;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "irrigation_time")
public class IrrigationTime {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "valve", referencedColumnName = "id")
  private Valve valve;

  @Column(name = "initial-time", nullable = false)
  private LocalTime initialTime;

  @Column(name = "final-time", nullable = false)
  private LocalTime finalTime;
}
