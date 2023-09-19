package com.ifmt.seedlingNursery.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifmt.seedlingNursery.Model.PlantImages;
import com.ifmt.seedlingNursery.Service.PlantImagesService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/plant-images")
public class PlantImagesController {
  PlantImagesService plantImagesService;

  @GetMapping("/{id}")
  public ResponseEntity<PlantImages> getPlantImages(@PathVariable Long id) {
    return new ResponseEntity<PlantImages>(plantImagesService.getByID(id), HttpStatus.OK);
  }

}
