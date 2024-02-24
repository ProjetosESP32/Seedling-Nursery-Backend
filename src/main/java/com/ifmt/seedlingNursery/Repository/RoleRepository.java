package com.ifmt.seedlingNursery.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifmt.seedlingNursery.Model.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {
  Optional<Roles> findByName(String name);
}
