package com.sistemasEmbarcados.gerenciamentoMudas.Resource;

import com.sistemasEmbarcados.gerenciamentoMudas.Model.Plant;
import com.sistemasEmbarcados.gerenciamentoMudas.Model.Especie;
import com.sistemasEmbarcados.gerenciamentoMudas.Service.EspecieService;
import com.sistemasEmbarcados.gerenciamentoMudas.dto.EspecieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/especie")
public class EspecieResource {

    @Autowired
    EspecieService especieService;

    @PostMapping("/save")
    public ResponseEntity<Especie> salvarEspecie(@RequestBody EspecieDTO especieDTO)
            throws UnsupportedEncodingException {
        return ResponseEntity.ok(especieService.SalvarEspecie(especieDTO));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<EspecieDTO>> buscarTodasEspecies() {
        return ResponseEntity.ok(especieService.buscarTodasEspecies());
    }
}
