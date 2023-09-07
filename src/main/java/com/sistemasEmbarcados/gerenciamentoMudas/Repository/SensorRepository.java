package com.sistemasEmbarcados.gerenciamentoMudas.Repository;

import com.sistemasEmbarcados.gerenciamentoMudas.Model.Semente;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Sensor;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.ValorSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
