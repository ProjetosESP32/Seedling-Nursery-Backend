package com.ifmt.gerenciamentoMudas.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifmt.gerenciamentoMudas.Model.Plant;
import com.ifmt.gerenciamentoMudas.Service.PlantService;
import com.ifmt.gerenciamentoMudas.Service.PlantServiceImpl;
import com.ifmt.gerenciamentoMudas.dto.ArvoreMatrizDTO;
import com.ifmt.gerenciamentoMudas.dto.SementeDTO;

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
