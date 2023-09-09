package com.ifmt.seedlingNursery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifmt.seedlingNursery.Model.Plant;
import com.ifmt.seedlingNursery.Model.Specie;

@Repository
public interface SpecieRepository extends JpaRepository<Specie, Long> {
}
