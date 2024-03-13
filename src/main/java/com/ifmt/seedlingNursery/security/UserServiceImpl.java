package com.ifmt.seedlingNursery.security;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.Roles;
import com.ifmt.seedlingNursery.Model.Users;
import com.ifmt.seedlingNursery.Repository.UserRepository;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserDetailsService {

  UserRepository userRepository;
  BCryptPasswordEncoder bCryptPasswordEncoder;

  public Users getUser(Long id) {
    Optional<Users> user = userRepository.findById(id);
    return unrwapUser(user, id);
  }

  public Users getUser(String username) {
    Optional<Users> user = userRepository.findByUsername(username);
    return unrwapUser(user, 404L);
  }

  public Users saveUser(Users user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    Users userEntity = this.getUser(username);
    Collection<GrantedAuthority> granted = mapRolesToAuthorities(userEntity.getRoles());
    System.out.println("\nroles: " + userEntity.getRoles().get(0).getName());
    return new User(userEntity.getUsername(), userEntity.getPassword(), granted);
  }

  public static Users unrwapUser(Optional<Users> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, Users.class);
  }

  private Collection<GrantedAuthority> mapRolesToAuthorities(List<Roles> roles) {
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
  }
}
