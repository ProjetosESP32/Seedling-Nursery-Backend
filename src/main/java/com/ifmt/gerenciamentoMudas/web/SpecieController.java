package com.ifmt.gerenciamentoMudas.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifmt.gerenciamentoMudas.Model.Specie;
import com.ifmt.gerenciamentoMudas.Model.Plant;
import com.ifmt.gerenciamentoMudas.Service.SpecieServiceImpl;
import com.ifmt.gerenciamentoMudas.dto.EspecieDTO;

import lombok.AllArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.http.HttpResponse;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/specie")
public class SpecieController {

    SpecieServiceImpl specieService;

    @GetMapping("/{id}")
    public ResponseEntity<Specie> getSpecie(@PathVariable Long id) {
        return new ResponseEntity<Specie>(specieService.getSpecie(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Specie> saveSpecie(@RequestBody Specie specie) {
        return new ResponseEntity<Specie>(specieService.saveSpecie(specie), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Specie>> getAllSpecies() {
        return new ResponseEntity<List<Specie>>(specieService.getAllSpecies(), HttpStatus.OK);
    }

}
