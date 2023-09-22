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
@Table(name = "specie_images")
public class SpecieImages {

  @Id
  @Column(name = "id")
  private Long id;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(name = "image")
  private byte[] image;
}
