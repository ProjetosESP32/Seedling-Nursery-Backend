package com.sistemasEmbarcados.gerenciamentoMudas.Service;

import com.sistemasEmbarcados.gerenciamentoMudas.Model.ArvoreMatriz;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Localizacao;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.MicroControlador;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Semente;
import com.sistemasEmbarcados.gerenciamentoMudas.Repository.ArvoreMatrizRepository;
import com.sistemasEmbarcados.gerenciamentoMudas.Repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalizacaoService {

    @Autowired
    LocalizacaoRepository localizacaoRepository;

    @Autowired
    ArvoreMatrizService arvoreMatrizService;

    @Autowired
    ArvoreMatrizRepository arvoreMatrizRepository;

    public Localizacao salvarNovaLocalizacao(Localizacao localizacao) {
        List<MicroControlador> microControladorList = new ArrayList<>();
        localizacao.setMicroControladorList(microControladorList);

        for (int i = 0; i < localizacao.getQuantidadeMicroControlador(); i++) {
            MicroControlador microControlador = new MicroControlador();
            microControlador.setLocalizacaoMicroControlador(localizacao);
            localizacao.getMicroControladorList().add(microControlador);
        }
        return localizacaoRepository.save(localizacao);
    }

    public List<Localizacao> buscarTodasAsLocalizacoes() {
        return localizacaoRepository.findAll();
    }

    public Localizacao buscarLocalizacaoById(Long id) {
        return localizacaoRepository.findById(id).get();
    }

    public Localizacao alterarListaMicroControladores(Long id, List<MicroControlador> microControladorList) {
        Localizacao localizacao = localizacaoRepository.findById(id).get();
        localizacao.setMicroControladorList(microControladorList);
        return localizacaoRepository.save(localizacao);
    }

    public List<MicroControlador> buscarListaMicroControladorApartirIdLocalizacao(Long id) {
        return localizacaoRepository.buscarListaMicroControladorApartirIdLocalizacao(id);
    }

    public List<Semente> buscarSementeApartirIdLocalizacao(Long id) {
        return localizacaoRepository.buscarSementeApartirIdLocalizacao(id);
    }

    public Localizacao salvarListaSementesApartirIdArvoreMatriz(Long idArvoreMatriz, Long idLocalizacao) {
        ArvoreMatriz arvoreMatriz = arvoreMatrizService.buscarArvoreMatrizById(idArvoreMatriz);
        Localizacao localizacao = localizacaoRepository.findById(idLocalizacao).get();

        for (int i = 0; i < arvoreMatriz.getSementeList().size(); i++) {
            arvoreMatriz.getSementeList().get(i).setLocalizacaoSemente(localizacao);
            localizacao.getSementeList().add(arvoreMatriz.getSementeList().get(i));
        }

        arvoreMatrizRepository.save(arvoreMatriz);
        return localizacaoRepository.save(localizacao);

    }
}
