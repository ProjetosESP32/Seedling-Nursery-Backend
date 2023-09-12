package com.ifmt.seedlingNursery.web;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifmt.seedlingNursery.Model.Plant;
import com.ifmt.seedlingNursery.Service.PlantService;
import com.ifmt.seedlingNursery.dto.SpeciesPageRow;

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

    @GetMapping("/specie/{specieId}")
    public ResponseEntity<List<Plant>> getPlantsBySpecie(@PathVariable Long specieId) {
        return new ResponseEntity<>(plantService.getSpeciePlants(specieId), HttpStatus.OK);
    }

    @GetMapping("/address/{address}")
    public ResponseEntity<List<Plant>> getPlantsByAddress(@PathVariable String address) {
        return new ResponseEntity<>(plantService.getPlantsByAddress(address),
                HttpStatus.OK);
    }

    @GetMapping("/shelf/{shelfId}")
    public ResponseEntity<List<Plant>> getPlantsByShelf(@PathVariable int shelfId) {
        return new ResponseEntity<>(plantService.getPlantsByShelf(shelfId), HttpStatus.OK);
    }

    // to populate rows of the tables of the frontend

    /*
     * returns the selected page rows of the table of PlantsBySpecie component.
     * in the header, I've added the total size of the table
     */
    @GetMapping("/plants-per-specie-page/{index}/page-size/{pageSize}/specie/{specieId}/{matrix}/{seedling}/{seed}")
    public ResponseEntity<List<SpeciesPageRow>> getPlantsPerSpeciePage(@PathVariable int index,
            @PathVariable int pageSize,
            @PathVariable Long specieId, @PathVariable int matrix, @PathVariable int seedling,
            @PathVariable int seed) {

        HttpHeaders header = new HttpHeaders();
        header.add("tableSize",
                Integer.toString(plantService.getPlantsBySpecieCount(specieId, matrix, seedling, seed)));
        return new ResponseEntity<>(
                plantService.getPlantsPerSpeciePage(index, pageSize, specieId, matrix, seedling, seed), header,
                HttpStatus.OK);
    }

    // counts

    @GetMapping("/count")
    public int getPlantsCount() {
        return plantService.getPlantsCount();
    }

}
