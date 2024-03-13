package com.ifmt.seedlingNursery.web;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifmt.seedlingNursery.Model.Roles;
import com.ifmt.seedlingNursery.Model.Users;
import com.ifmt.seedlingNursery.Service.RolesServiceImpl;
import com.ifmt.seedlingNursery.security.UserServiceImpl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
  UserServiceImpl userService;
  RolesServiceImpl rolesService;

  @PostMapping("/register/{roleName}")
  public ResponseEntity<Users> createUser(@Valid @RequestBody Users user, @PathVariable String roleName) {
    Roles role = rolesService.getRoleByName(roleName);
    user.setRoles(Arrays.asList(role));
    userService.saveUser(user);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
