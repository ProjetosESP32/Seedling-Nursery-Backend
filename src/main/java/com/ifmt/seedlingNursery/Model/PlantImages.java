package com.ifmt.seedlingNursery.Model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "plant_images")
public class PlantImages {

  @Id
  @Column(name = "id")
  private Long id;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(name = "image")
  private byte[] image;
}
