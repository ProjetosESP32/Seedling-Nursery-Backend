package com.sistemasEmbarcados.gerenciamentoMudas.Service;

import com.sistemasEmbarcados.gerenciamentoMudas.Model.Localizacao;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.MicroControlador;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Sensor;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.ValorSensor;
import com.sistemasEmbarcados.gerenciamentoMudas.Repository.LocalizacaoRepository;
import com.sistemasEmbarcados.gerenciamentoMudas.Repository.SensorRepository;
import com.sistemasEmbarcados.gerenciamentoMudas.dto.SensorDTO;
import com.sistemasEmbarcados.gerenciamentoMudas.dto.ValorSensorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorService {

    @Autowired
    LocalizacaoService localizacaoService;

    @Autowired
    LocalizacaoRepository localizacaoRepository;

    @Autowired
    SensorRepository SensorRepository;

    public Localizacao salvarSensor(SensorDTO sensorDTO) {
        Localizacao localizacao = localizacaoService.buscarLocalizacaoById(sensorDTO.getIdLocalizacao());

        for (MicroControlador microControlador : localizacao.getMicroControladorList()) {
            if (microControlador.getId() == sensorDTO.getIdMicrocontrolador()) {
                Sensor sensor = new Sensor();
                sensor.setTipo(sensorDTO.getTipoSensor());
                sensor.setMicroControlador(microControlador);
                microControlador.getSensorList().add(sensor);
            }
        }
        return localizacaoRepository.save(localizacao);
    }

    public ValorSensor salvarValorSensor(ValorSensorDTO valorRecebido) {
        Localizacao localizacao = localizacaoService.buscarLocalizacaoById(valorRecebido.getIdLocalizacao());
        //novo valor a ser colocado, chega do esp32
        ValorSensor valor = new ValorSensor();

        //percorre os micro, depois os sensores de acordo com id e adiciona o valor que veio
        for (MicroControlador microControlador : localizacao.getMicroControladorList()) {
            if (microControlador.getId() == valorRecebido.getIdMicrocontrolador()) {
                for (Sensor sensor : microControlador.getSensorList()) {
                    if (sensor.getId() == valorRecebido.getIdSensor()) {

                        valor.setValor(valorRecebido.getValorSensor());
                        valor.setSensor(sensor);
                        sensor.getListValores().add(valor);

                    }
                }
            }
        }

        localizacaoRepository.save(localizacao);
        return valor;
    }


}
