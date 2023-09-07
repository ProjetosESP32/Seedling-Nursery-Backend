package com.sistemasEmbarcados.gerenciamentoMudas.Resource;

import com.sistemasEmbarcados.gerenciamentoMudas.Model.Plant;
import com.sistemasEmbarcados.gerenciamentoMudas.Service.ArvoreMatrizService;
import com.sistemasEmbarcados.gerenciamentoMudas.dto.ArvoreMatrizDTO;
import com.sistemasEmbarcados.gerenciamentoMudas.dto.SementeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arvoreMatriz")
public class ArvoreMatrizResource {

    @Autowired
    ArvoreMatrizService arvoreMatrizService;

    @PostMapping("/save")
    public ResponseEntity<Plant> salvarArvoreMatriz(@RequestBody ArvoreMatrizDTO arvoreMatrizDTO) {
        return ResponseEntity.ok(arvoreMatrizService.salvarArvoreMatriz(arvoreMatrizDTO));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ArvoreMatrizDTO> buscarArvoreMatriz(@PathVariable Long id) {
        return ResponseEntity.ok(arvoreMatrizService.buscarArvoreMatrizByIdDTO(id));
    }

    @PostMapping("/update")
    public ResponseEntity<Plant> alterarSementeApartirIdArvoreMatriz(@RequestBody ArvoreMatrizDTO arvoreMatrizDTO) {
        return ResponseEntity.ok(arvoreMatrizService.atualizarInformacoesArvoreMatriz(arvoreMatrizDTO));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<ArvoreMatrizDTO>> buscarTodasArvoresMatriz() {
        return ResponseEntity.ok(arvoreMatrizService.buscarTodasArvoresMatriz());
    }
}
