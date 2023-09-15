package com.ifmt.seedlingNursery.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifmt.seedlingNursery.Model.Valve;
import com.ifmt.seedlingNursery.Service.ValveService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/valve")
public class ValveController {
  ValveService valveService;

  @PostMapping
  public ResponseEntity<Valve> saveValve(@RequestBody Valve valve) {
    return new ResponseEntity<Valve>(valveService.saveValve(valve), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Valve> getSpecie(@PathVariable Long id) {
    return new ResponseEntity<>(valveService.getValve(id), HttpStatus.OK);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Valve>> getAllValves() {
    return new ResponseEntity<List<Valve>>(valveService.getAllValves(), HttpStatus.OK);
  }

  @GetMapping("/shelf/{shelfId}")
  public ResponseEntity<List<Valve>> getValvesByShelf(@PathVariable int shelfId) {
    return new ResponseEntity<>(valveService.getValvesByShelf(shelfId), HttpStatus.OK);
  }
}
