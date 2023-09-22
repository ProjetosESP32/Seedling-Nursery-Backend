package com.ifmt.seedlingNursery.dto;

import java.time.LocalDate;

import com.ifmt.seedlingNursery.Model.Specie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlantDto {
  private Long id;
  private double height;
  private double shaftHeight;
  private double cap;
  private String cupFormation;
  private String trunkFormation;
  private int occurrenceDensity;
  private String city;
  private String soilType;
  private String vegetationType;
  private String pickupAddress;
  private String determiningName;
  private String latitude;
  private String longitude;
  private String altitude;
  private String associatedSpecies;
  private int stage;
  private Specie specie;
  private int leafs;
  private LocalDate plantingDate;
  private LocalDate donationDate;
  private int shelf;
  private String detInst;
  private String address;
  private Long originMatrix;
  private String fertRecord;
  private String pestRecord;
  private byte[] image;
  private String observations;
}
