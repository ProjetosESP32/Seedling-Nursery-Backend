package com.sistemasEmbarcados.gerenciamentoMudas.Resource;

import com.sistemasEmbarcados.gerenciamentoMudas.Model.ArvoreMatriz;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Semente;
import com.sistemasEmbarcados.gerenciamentoMudas.Service.SementeService;
import com.sistemasEmbarcados.gerenciamentoMudas.dto.SementeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semente")
public class SementeResource {

    @Autowired
    SementeService sementeService;

    @GetMapping("/find/{id}")
    public ResponseEntity<List<Semente>> buscarSementeApartirIdArvoreMatriz(@PathVariable Long id){
        return ResponseEntity.ok(sementeService.buscarSementesApartirIdArvoreMatriz(id));
    }

    @PostMapping("/update")
    public ResponseEntity<ArvoreMatriz> alterarSementeApartirIdArvoreMatriz(@RequestBody SementeDTO sementeDTO){
        return ResponseEntity.ok(sementeService.atualizarInformacoesSemente(sementeDTO));
    }

}
