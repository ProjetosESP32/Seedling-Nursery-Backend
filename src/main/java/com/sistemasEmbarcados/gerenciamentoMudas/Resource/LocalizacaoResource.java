package com.sistemasEmbarcados.gerenciamentoMudas.Resource;

import com.sistemasEmbarcados.gerenciamentoMudas.Model.ArvoreMatriz;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Localizacao;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.MicroControlador;
import com.sistemasEmbarcados.gerenciamentoMudas.Service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacao")
public class LocalizacaoResource {

    @Autowired
    LocalizacaoService localizacaoService;

    @PostMapping("/save")
    public ResponseEntity<Localizacao> salvarLocalizacao(@RequestBody Localizacao localizacao) {
        return ResponseEntity.ok(localizacaoService.salvarNovaLocalizacao(localizacao));
    }

    @PostMapping("/alocar")
    public ResponseEntity<Localizacao> alocarSementesApartirIdArvoreMatriz(@RequestParam Long idArvoreMatriz, @RequestParam Long idLocalizacao ) {
        return ResponseEntity.ok(localizacaoService.salvarListaSementesApartirIdArvoreMatriz(idArvoreMatriz,idLocalizacao));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Localizacao> alterarListaMicroControladoresLocalizacao(@RequestParam Long id, @RequestBody List<MicroControlador> controladorList) {
        return ResponseEntity.ok(localizacaoService.alterarListaMicroControladores(id,controladorList));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Localizacao>> buscarTodasLocalizacoes(){
        return ResponseEntity.ok(localizacaoService.buscarTodasAsLocalizacoes());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Localizacao> buscarLocalizacao(@PathVariable Long id){
        return ResponseEntity.ok(localizacaoService.buscarLocalizacaoById(id));
    }
}
