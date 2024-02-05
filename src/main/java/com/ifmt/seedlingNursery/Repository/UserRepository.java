package com.ifmt.seedlingNursery.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifmt.seedlingNursery.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
