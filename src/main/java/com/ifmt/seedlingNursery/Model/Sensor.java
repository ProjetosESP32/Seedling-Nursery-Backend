package com.ifmt.seedlingNursery.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id-microcontroller")
    private int idMicrocontroller;

    @Column(name = "id-location")
    private int idLocation;

    @Column(name = "type")
    private String type;

    @Column(name = "mesure")
    private String mesure;

    @Column(name = "observations", length = 10000)
    private String observations;
}
