package com.ifmt.seedlingNursery.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifmt.seedlingNursery.Model.Plant;
import com.ifmt.seedlingNursery.Service.PlantService;
import com.ifmt.seedlingNursery.Service.PlantServiceImpl;
import com.ifmt.seedlingNursery.dto.ArvoreMatrizDTO;
import com.ifmt.seedlingNursery.dto.SementeDTO;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/plant")
public class PlantController {

    PlantService plantService;

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlant(@PathVariable Long id) {
        return new ResponseEntity<>(plantService.getPlant(id), HttpStatus.OK);
    }

}
