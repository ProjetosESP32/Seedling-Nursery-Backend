package com.ifmt.seedlingNursery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.Roles;
import com.ifmt.seedlingNursery.Model.Sensor;
import com.ifmt.seedlingNursery.Repository.RolesRepository;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@SuppressWarnings("null")
@AllArgsConstructor
@Service
public class RolesServiceImpl {
  RolesRepository rolesRepository;

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
