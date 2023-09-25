package com.ifmt.seedlingNursery.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.Specie;
import com.ifmt.seedlingNursery.Model.SpecieImages;
import com.ifmt.seedlingNursery.Repository.SpecieImagesRepository;
import com.ifmt.seedlingNursery.Repository.SpecieRepository;
import com.ifmt.seedlingNursery.dto.SpecieDto;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SpecieServiceImpl implements SpecieService {

    SpecieRepository specieRepository;
    SpecieImagesRepository specieImagesRepository;

    @Override
    public Specie getSpecie(Long id) {
        return unwrapSpecie(specieRepository.findById(id), id);
    }

    @Override
    public Specie saveSpecie(SpecieDto specieDto) {
        // building Specie entity
        Specie specie = new Specie();
        BeanUtils.copyProperties(specieDto, specie);

        // saving to repo
        Specie specie2 = specieRepository.save(specie);

        // getting and saving image
        SpecieImages image = new SpecieImages(specie2.getId(), specieDto.getImage());
        specieImagesRepository.save(image);

        return specie2;
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

    // count
    @Override
    public int getSpeciesCount() {
        return specieRepository.getSpeciesCount();
    }

    static Specie unwrapSpecie(Optional<Specie> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        }
        throw new EntityNotFoundException(id, Specie.class);
    }
}
