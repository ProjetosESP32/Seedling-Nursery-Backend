package com.sistemasEmbarcados.gerenciamentoMudas.Service;


import com.sistemasEmbarcados.gerenciamentoMudas.Model.ArvoreMatriz;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Semente;
import com.sistemasEmbarcados.gerenciamentoMudas.Repository.ArvoreMatrizRepository;
import com.sistemasEmbarcados.gerenciamentoMudas.dto.ArvoreMatrizDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArvoreMatrizService {

    @Autowired
    ArvoreMatrizRepository arvoreMatrizRepository;

    public ArvoreMatriz salvarArvoreMatriz(ArvoreMatrizDTO arvoreMatrizDTO) {

        List<Semente> sementeList = new ArrayList<>();
        ArvoreMatriz arvoreMatriz = arvoreMatrizDTOparaArvoreMatriz(arvoreMatrizDTO);
        arvoreMatriz.setSementeList(sementeList);


        for (int i = 0; i < arvoreMatriz.getQuantidadeSementes(); i++) {
            Semente semente = new Semente();
            semente.setEstadoSemente("semente");
            semente.setArvoreMatriz(arvoreMatriz);
            arvoreMatriz.getSementeList().add(semente);
        }

        return arvoreMatrizRepository.save(arvoreMatriz);
    }

    public ArvoreMatriz atualizarInformacoesArvoreMatriz(ArvoreMatrizDTO arvoreMatrizDTO){
        ArvoreMatriz arvoreMatriz = arvoreMatrizDTOparaArvoreMatriz(arvoreMatrizDTO);
        arvoreMatriz.setObservacoes(arvoreMatrizDTO.getObservacoes());
        arvoreMatriz.setId(arvoreMatrizDTO.getId());
        return arvoreMatrizRepository.save(arvoreMatriz);
    }

    private static ArvoreMatriz arvoreMatrizDTOparaArvoreMatriz(ArvoreMatrizDTO arvoreMatrizDTO){

        ArvoreMatriz arvoreMatriz = new ArvoreMatriz();
        arvoreMatriz.setAlturaArvore(arvoreMatrizDTO.getAlturaArvore());
        arvoreMatriz.setNomeCientifico(arvoreMatrizDTO.getNomeCientifico());
        arvoreMatriz.setNomeComum(arvoreMatrizDTO.getNomeComum());
        arvoreMatriz.setCap(arvoreMatrizDTO.getCap());
        arvoreMatriz.setAltitude(arvoreMatrizDTO.getAltitude());
        arvoreMatriz.setDensidadeOcorrencia(arvoreMatrizDTO.getDensidadeOcorrencia());
        arvoreMatriz.setTipovegetacao(arvoreMatrizDTO.getTipovegetacao());
        arvoreMatriz.setQuantidadeSementes(arvoreMatrizDTO.getQuantidadeSementes());
        arvoreMatriz.setLongitude(arvoreMatrizDTO.getLongitude());
        arvoreMatriz.setUf(arvoreMatrizDTO.getUf());
        arvoreMatriz.setAlturaFuste(arvoreMatrizDTO.getAlturaFuste());
        arvoreMatriz.setFormacaoCopa(arvoreMatrizDTO.getFormacaoCopa());
        arvoreMatriz.setFormacaoTronco(arvoreMatrizDTO.getFormacaoTronco());
        arvoreMatriz.setCidade(arvoreMatrizDTO.getCidade());
        arvoreMatriz.setTipoSolo(arvoreMatrizDTO.getTipoSolo());
        arvoreMatriz.setEnderecoColeta(arvoreMatrizDTO.getEnderecoColeta());
        arvoreMatriz.setNomeDeterminador(arvoreMatrizDTO.getNomeDeterminador());
        arvoreMatriz.setLagitude(arvoreMatrizDTO.getLagitude());
        arvoreMatriz.setEspeciesAssociadas(arvoreMatrizDTO.getEspeciesAssociadas());
        arvoreMatriz.setImagem(arvoreMatrizDTO.getImagemMatriz()
                .substring(arvoreMatrizDTO.getImagemMatriz().indexOf(",") + 1)
                .getBytes());
        arvoreMatriz.setObservacoes(arvoreMatrizDTO.getObservacoes());

        return arvoreMatriz;
    }

    private static ArvoreMatrizDTO arvoreMatrizparaArvoreMatrizDTO(ArvoreMatriz arvoreMatriz){

        ArvoreMatrizDTO arvoreMatrizDTO = new ArvoreMatrizDTO();
        arvoreMatrizDTO.setId(arvoreMatriz.getId());
        arvoreMatrizDTO.setAlturaArvore(arvoreMatriz.getAlturaArvore());
        arvoreMatrizDTO.setNomeCientifico(arvoreMatriz.getNomeCientifico());
        arvoreMatrizDTO.setNomeComum(arvoreMatriz.getNomeComum());
        arvoreMatrizDTO.setCap(arvoreMatriz.getCap());
        arvoreMatrizDTO.setAltitude(arvoreMatriz.getAltitude());
        arvoreMatrizDTO.setDensidadeOcorrencia(arvoreMatriz.getDensidadeOcorrencia());
        arvoreMatrizDTO.setTipovegetacao(arvoreMatriz.getTipovegetacao());
        arvoreMatrizDTO.setQuantidadeSementes(arvoreMatriz.getQuantidadeSementes());
        arvoreMatrizDTO.setLongitude(arvoreMatriz.getLongitude());
        arvoreMatrizDTO.setUf(arvoreMatriz.getUf());
        arvoreMatrizDTO.setAlturaFuste(arvoreMatriz.getAlturaFuste());
        arvoreMatrizDTO.setFormacaoCopa(arvoreMatriz.getFormacaoCopa());
        arvoreMatrizDTO.setFormacaoTronco(arvoreMatriz.getFormacaoTronco());
        arvoreMatrizDTO.setCidade(arvoreMatriz.getCidade());
        arvoreMatrizDTO.setTipoSolo(arvoreMatriz.getTipoSolo());
        arvoreMatrizDTO.setEnderecoColeta(arvoreMatriz.getEnderecoColeta());
        arvoreMatrizDTO.setNomeDeterminador(arvoreMatriz.getNomeDeterminador());
        arvoreMatrizDTO.setLagitude(arvoreMatriz.getLagitude());
        arvoreMatrizDTO.setEspeciesAssociadas(arvoreMatriz.getEspeciesAssociadas());
        arvoreMatrizDTO.setImagemMatriz(new String(arvoreMatriz.getImagem()));
        arvoreMatrizDTO.setObservacoes(arvoreMatriz.getObservacoes());

        return arvoreMatrizDTO;
    }

    public List<ArvoreMatrizDTO> buscarTodasArvoresMatriz() {

        List<ArvoreMatrizDTO> matrizDTOList = new ArrayList<>();
        List<ArvoreMatriz> arvoreMatrizList = arvoreMatrizRepository.findAll();

        for(ArvoreMatriz arvoreMatriz : arvoreMatrizList){
            matrizDTOList.add(arvoreMatrizparaArvoreMatrizDTO(arvoreMatriz));
        }

        return matrizDTOList;
    }

    public ArvoreMatrizDTO buscarArvoreMatrizByIdDTO(Long id) {
        return arvoreMatrizparaArvoreMatrizDTO(arvoreMatrizRepository.findById(id).get());
    }

    public ArvoreMatriz buscarArvoreMatrizById(Long id) {
        return arvoreMatrizRepository.findById(id).get();
    }

    public List<Semente> buscarSementesApartirIdArvoreMatriz(Long id) {
        return arvoreMatrizRepository.buscarListaSementeApartirIdArvoreMatriz(id);
    }
}
