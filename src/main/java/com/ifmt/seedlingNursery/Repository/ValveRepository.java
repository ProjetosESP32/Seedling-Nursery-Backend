package com.ifmt.seedlingNursery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifmt.seedlingNursery.Model.Valve;
import java.util.List;

@Repository
public interface ValveRepository extends JpaRepository<Valve, Long> {
  List<Valve> findByShelf(int shelf);
}
