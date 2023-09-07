package com.sistemasEmbarcados.gerenciamentoMudas.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "arvore_matriz")
public class Plant implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // old: id_arvore_matriz
    private Long id;

    @Column(name = "height") // old: altura_arvore
    private double height;

    @Column(name = "shaft_height") // old: altura_fuste
    private double shaftHeight;

    @Column(name = "cap")
    private double cap;

    @Column(name = "cup_formation")
    private String cupFormation;

    @Column(name = "trunk_formation")
    private String trunkFormation;

    @Column(name = "occurrence_density")
    private int occurrenceDensity;

    @Column(name = "city")
    private String city;

    @Column(name = "soil_type")
    private String soilType;

    @Column(name = "vegetation_type")
    private String vegetationType;

    @Column(name = "pickup_address")
    private String pickupAddress;

    @Column(name = "determining_name")
    private String determiningName;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "altitude")
    private String altitude;

    @Column(name = "associated_species")
    private String associatedSpecies;

    @Column(name = "stage")
    private int stage;

    @Column(name = "specie")
    private String specie;

    @Column(name = "leafs") // receives the leafs number of the plant
    private String leafs;

    @Column(name = "planting_date")
    private LocalDate plantingDate;

    @Column(name = "donation_date")
    private LocalDate donationDate;

    @Column(name = "shelf")
    private int shelf;

    @Column(name = "det_inst") // determining institute
    private String detInst;

    @Column(name = "address") // current address
    private String address;

    // origin matrix id. Its a foreign key to the same table...
    @Column(name = "origin_matrix")
    private Long originMatrix;

    @Column(name = "fert_record", length = 10000)
    private String fertRecord;

    @Column(name = "pest_record", length = 10000)
    private String pestRecord;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "imagem_matriz", columnDefinition = "bytea")
    @JsonIgnore
    private byte[] imagem;

    @Column(name = "observations", length = 10000)
    private String observations;

}
