package com.ifmt.seedlingNursery.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifmt.seedlingNursery.Model.Roles;

@SuppressWarnings("null")
public interface RolesRepository extends JpaRepository<Roles, Long> {
  Optional<Roles> findById(Long id);

  Optional<Roles> findByName(String name);
}
