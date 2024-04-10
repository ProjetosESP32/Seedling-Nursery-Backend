package com.ifmt.seedlingNursery.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.Roles;
import com.ifmt.seedlingNursery.Model.Users;
import com.ifmt.seedlingNursery.Repository.RolesRepository;
import com.ifmt.seedlingNursery.Repository.UserRepository;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;
import com.ifmt.seedlingNursery.security.SecretConsts;
import com.ifmt.seedlingNursery.security.UserServiceImpl;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RolesServiceImpl {

  RolesRepository rolesRepository;
  UserServiceImpl userServiceImpl;
  UserRepository userRepository;
  SecretConsts secretConsts;

  // Inserts Admin and User roles into db, if it's not there already
  @PostConstruct
  private void postConstruct() {
    if (!rolesRepository.findById(1L).isPresent()) {
      this.rolesRepository.save(new Roles(1L, "ADMIN"));
      this.rolesRepository.save(new Roles(2L, "USER"));
    }

    if (!userRepository.findByUsername("Admin").isPresent()) {
      Users user = new Users(null, "Admin", secretConsts.adminPass,
          Arrays.asList(new Roles(1L, "ADMIN")));
      userServiceImpl.saveUser(user);
    }
  }

  public Roles saveRoles(Roles roles) {
    return rolesRepository.save(roles);
  }

  public Roles getRole(Long id) {
    return unwrapRoles(rolesRepository.findById(id), id);
  }

  public Roles getRoleByName(String name) {
    return unwrapRoles(rolesRepository.findByName(name), 404L);
  }

  public List<Roles> getAllRoles() {
    return rolesRepository.findAll();
  }

  static Roles unwrapRoles(Optional<Roles> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, Roles.class);
  }
}
