package com.ifmt.seedlingNursery.Service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.Users;
import com.ifmt.seedlingNursery.Repository.UserRepository;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  UserRepository userRepository;
  BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public Users getUser(Long id) {
    Optional<Users> user = userRepository.findById(id);
    return unrwapUser(user, id);
  }

  @Override
  public Users getUser(String username) {
    Optional<Users> user = userRepository.findByUsername(username);
    return unrwapUser(user, 404L);
  }

  @Override
  public Users saveUser(Users user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  public static Users unrwapUser(Optional<Users> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, Users.class);
  }
}
