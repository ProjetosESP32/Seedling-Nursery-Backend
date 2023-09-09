package com.ifmt.seedlingNursery.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "valores_sensores")
public class ValorSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "valor_sensor")
    private String valor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sensor_id")
    @JsonBackReference(value = "sensor-valorSensor")
    private Sensor sensor;

    @Column(name = "horario_entrada")
    @CreationTimestamp
    private LocalDateTime horario;

}
