package com.ifmt.gerenciamentoMudas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifmt.gerenciamentoMudas.Model.Specie;
import com.ifmt.gerenciamentoMudas.Repository.SpecieRepository;
import com.ifmt.gerenciamentoMudas.dto.EspecieDTO;
import com.ifmt.gerenciamentoMudas.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SpecieServiceImpl implements SpecieService {

    SpecieRepository specieRepository;

    @Override
    public Specie getSpecie(Long id) {
        return unwrapSpecie(specieRepository.findById(id), id);
    }

    @Override
    public Specie saveSpecie(Specie specie) {
        return specieRepository.save(specie);
    }

    @Override
    public List<Specie> getAllSpecies() {
        return specieRepository.findAll();
    }

    static Specie unwrapSpecie(Optional<Specie> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        }
        throw new EntityNotFoundException(id, Specie.class);
    }
}
