package com.ifmt.seedlingNursery.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifmt.seedlingNursery.Model.SpecieImages;
import com.ifmt.seedlingNursery.Service.SpecieImagesService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/specie-images")
public class SpecieImagesController {
  SpecieImagesService specieImagesService;

  @GetMapping("/{id}")
  public ResponseEntity<SpecieImages> getSpecieImages(@PathVariable Long id) {
    return new ResponseEntity<SpecieImages>(specieImagesService.getSpecieImage(id), HttpStatus.OK);
  }
}
