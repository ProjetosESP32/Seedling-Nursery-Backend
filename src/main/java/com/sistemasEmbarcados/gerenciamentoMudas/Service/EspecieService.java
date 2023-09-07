package com.sistemasEmbarcados.gerenciamentoMudas.Service;

import com.sistemasEmbarcados.gerenciamentoMudas.Model.Especie;
import com.sistemasEmbarcados.gerenciamentoMudas.Repository.EspecieRepository;
import com.sistemasEmbarcados.gerenciamentoMudas.dto.EspecieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
public class EspecieService {

    @Autowired
    EspecieRepository especieRepository;

    public Especie SalvarEspecie(EspecieDTO especieDTO) throws UnsupportedEncodingException {
        Especie especie = new Especie();
        especie.setDescricao(especieDTO.getDescricao());
        especie.setNomeComum(especieDTO.getNomeComum());
        especie.setNomeCientifico(especieDTO.getNomeCientifico());
        especie.setImagem(especieDTO.getImagem()
                .substring(especieDTO.getImagem().indexOf(",") + 1)
                .getBytes());
        return especieRepository.save(especie);
    }

    public List<EspecieDTO> buscarTodasEspecies() {
        List<Especie> especieList = especieRepository.findAll();
        List<EspecieDTO> especieDTOList = new ArrayList<>();

        for (Especie especie : especieList) {
            EspecieDTO especieDTO = new EspecieDTO();
            especieDTO.setDescricao(especie.getDescricao());
            especieDTO.setNomeComum(especie.getNomeComum());
            especieDTO.setNomeCientifico(especie.getNomeCientifico());
            especieDTO.setImagem(new String(especie.getImagem()));
            especieDTOList.add(especieDTO);
        }

        return especieDTOList;

    }
}
