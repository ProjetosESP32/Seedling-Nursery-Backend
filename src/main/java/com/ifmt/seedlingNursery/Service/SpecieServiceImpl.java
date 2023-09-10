package com.ifmt.seedlingNursery.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.Specie;
import com.ifmt.seedlingNursery.Repository.SpecieRepository;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

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

    /*
     * given the id of the fist specie, returns the list of 7 species starting with
     * the specie of the id
     */
    @Override
    public List<Specie> get7Species(int num) {
        List<Specie> species = specieRepository.findAll();
        List<Specie> page = new ArrayList<>();

        for (int i = num * 7; i < num * 7 + 7 && i < species.size(); i++) {
            page.add(species.get(i));
        }

        return page;
    }

    static Specie unwrapSpecie(Optional<Specie> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        }
        throw new EntityNotFoundException(id, Specie.class);
    }
}
