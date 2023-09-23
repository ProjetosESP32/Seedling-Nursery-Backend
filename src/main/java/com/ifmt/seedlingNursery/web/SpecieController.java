package com.ifmt.seedlingNursery.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifmt.seedlingNursery.Model.Specie;
import com.ifmt.seedlingNursery.Service.SpecieServiceImpl;
import com.ifmt.seedlingNursery.dto.SpecieDto;

import lombok.AllArgsConstructor;

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
    public ResponseEntity<Specie> saveSpecie(@RequestBody SpecieDto specieDto) {
        return new ResponseEntity<Specie>(specieService.saveSpecie(specieDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Specie>> getAllSpecies() {
        return new ResponseEntity<List<Specie>>(specieService.getAllSpecies(), HttpStatus.OK);
    }

    @GetMapping("/page/{num}")
    public ResponseEntity<List<Specie>> get7Species(@PathVariable int num) {
        return new ResponseEntity<List<Specie>>(specieService.get7Species(num), HttpStatus.OK);
    }

}
