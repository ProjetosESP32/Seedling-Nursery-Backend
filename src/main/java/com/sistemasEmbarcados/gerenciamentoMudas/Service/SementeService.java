package com.sistemasEmbarcados.gerenciamentoMudas.Service;

import com.sistemasEmbarcados.gerenciamentoMudas.Model.ArvoreMatriz;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Semente;
import com.sistemasEmbarcados.gerenciamentoMudas.Repository.ArvoreMatrizRepository;
import com.sistemasEmbarcados.gerenciamentoMudas.Repository.LocalizacaoRepository;
import com.sistemasEmbarcados.gerenciamentoMudas.dto.SementeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SementeService {

    @Autowired
    ArvoreMatrizRepository arvoreMatrizRepository;

    @Autowired
    LocalizacaoRepository localizacaoRepository;

    public List<Semente> buscarSementesApartirIdArvoreMatriz(Long id) {
        return arvoreMatrizRepository.buscarListaSementeApartirIdArvoreMatriz(id);
    }

    public ArvoreMatriz atualizarInformacoesSemente(SementeDTO sementeDTO) {
        ArvoreMatriz arvoreMatriz = arvoreMatrizRepository.findById(sementeDTO.getIdArvoreMatriz()).get();
        for (Semente semente : arvoreMatriz.getSementeList()) {
            if (semente.getId() == sementeDTO.getIdSemente()) {
                LocalDate dateTime = LocalDate.now();
                if (semente.getObservacoesCrecimento() == null) {
                    semente.setObservacoesCrecimento("");
                }
                if (!sementeDTO.getDoencas().equals("")) {
                    String doenca = "DOENCA = " + dateTime + " | " + sementeDTO.getDoencas() + " \r\n ";
                    String concatenado = semente.getObservacoesCrecimento() + doenca;
                    semente.setObservacoesCrecimento(concatenado);
                }
                if (!sementeDTO.getAlturaPlanta().equals("")) {
                    String altura = "ALTURA = " + dateTime + " | " + sementeDTO.getAlturaPlanta();
                    String concatenado = semente.getObservacoesCrecimento() + altura + " \r\n ";
                    semente.setObservacoesCrecimento(concatenado);
                }
                if (!sementeDTO.getContagemFolha().equals("")) {
                    String contagem = "CONTAGEMFOLHA = " + dateTime + " | " + sementeDTO.getAlturaPlanta();
                    String concatenado = semente.getObservacoesCrecimento() + contagem + " \r\n ";
                    semente.setObservacoesCrecimento(concatenado);
                }
                if (!sementeDTO.getObservacoes().equals("")) {
                    String observacao = "OBSERVACOES = " + dateTime + " | " + sementeDTO.getAlturaPlanta();
                    String concatenado = semente.getObservacoesCrecimento() + observacao + " \r\n ";
                    semente.setObservacoesCrecimento(concatenado);
                }
                if (sementeDTO.getDataDoacao() != null) {
                    if (!sementeDTO.getDataDoacao().equals("")) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate ld = LocalDate.parse(sementeDTO.getDataDoacao(), formatter);
                        semente.setDataDoacao(ld);
                    }
                }
                if (sementeDTO.getDataPlantio() != null) {
                    if (!sementeDTO.getDataPlantio().equals("")) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate ld = LocalDate.parse(sementeDTO.getDataPlantio(), formatter);
                        semente.setDataPlantio(ld);
                    }
                }
                if (sementeDTO.getImagemSemente() != null) {
                    if (!sementeDTO.getImagemSemente().equals("")) {
                        semente.setImagem(sementeDTO.getImagemSemente()
                                .substring(sementeDTO.getImagemSemente().indexOf(",") + 1)
                                .getBytes());
                    }
                }
            }
        }

        return arvoreMatrizRepository.save(arvoreMatriz);
    }
}
