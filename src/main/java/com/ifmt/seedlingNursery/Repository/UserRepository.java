package com.ifmt.seedlingNursery.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifmt.seedlingNursery.Model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
  Optional<Users> findByUsername(String username);
}
