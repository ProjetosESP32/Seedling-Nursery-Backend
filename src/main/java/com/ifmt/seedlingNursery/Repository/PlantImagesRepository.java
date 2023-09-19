package com.ifmt.seedlingNursery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifmt.seedlingNursery.Model.PlantImages;

@Repository
public interface PlantImagesRepository extends JpaRepository<PlantImages, Long> {
}
