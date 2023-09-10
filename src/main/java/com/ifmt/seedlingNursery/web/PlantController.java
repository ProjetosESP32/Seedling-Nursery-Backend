package com.ifmt.seedlingNursery.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifmt.seedlingNursery.Model.Plant;
import com.ifmt.seedlingNursery.Service.PlantService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/plant")
public class PlantController {

    PlantService plantService;

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlant(@PathVariable Long id) {
        return new ResponseEntity<>(plantService.getPlant(id), HttpStatus.OK);
    }

    @PostMapping("/{specieId}")
    public ResponseEntity<Plant> savePlant(@RequestBody Plant plant, @PathVariable Long specieId) {
        return new ResponseEntity<>(plantService.savePlant(plant, specieId), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Plant>> getAllPlants() {
        return new ResponseEntity<>(plantService.getAllPlants(), HttpStatus.OK);
    }

    @GetMapping("/page/{index}/pageSize/{pageSize}")
    public ResponseEntity<List<Plant>> getPlantsPage(@PathVariable int index, @PathVariable int pageSize) {
        return new ResponseEntity<>(plantService.getPlantsPage(index, pageSize), HttpStatus.OK);
    }

    @GetMapping("specie/{specieId}")
    public ResponseEntity<List<Plant>> getPlantsBySpecie(@PathVariable Long specieId) {
        return new ResponseEntity<>(plantService.getSpeciePlants(specieId), HttpStatus.OK);
    }

    @GetMapping("address/{address}")
    public ResponseEntity<List<Plant>> getPlantsByAddress(@PathVariable String address) {
        return new ResponseEntity<>(plantService.getPlantsByAddress(address),
                HttpStatus.OK);
    }

    @GetMapping("shelf/{shelfId}")
    public ResponseEntity<List<Plant>> getPlantsByShelf(@PathVariable int shelfId) {
        return new ResponseEntity<>(plantService.getPlantsByShelf(shelfId), HttpStatus.OK);
    }

    @GetMapping("/count")
    public int getPlantsCount() {
        return plantService.getPlantsCount();
    }

}
