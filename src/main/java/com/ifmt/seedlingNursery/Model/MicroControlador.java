package com.ifmt.seedlingNursery.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "micro_controlador")
public class MicroControlador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_microcontrolador")
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "microControlador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sensor> sensorList;

    @JoinColumn(name = "id_localizacao")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "Localizacao-MicroControlador")
    private Localizacao localizacaoMicroControlador;
}
