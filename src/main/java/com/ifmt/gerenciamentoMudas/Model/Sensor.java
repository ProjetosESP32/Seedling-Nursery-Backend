package com.ifmt.gerenciamentoMudas.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "sensores")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_sensor")
    private Long id;

    @Column(name = "tipo_sensor")
    private String tipo;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference(value = "sensor-valorSensor")
    private List<ValorSensor> listValores;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_microcontrolador")
    @JsonBackReference
    private MicroControlador microControlador;
}
