package com.ifmt.seedlingNursery.Service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ifmt.seedlingNursery.Model.User;
import com.ifmt.seedlingNursery.Repository.UserRepository;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  UserRepository userRepository;
  BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public User getUser(Long id) {
    Optional<User> user = userRepository.findById(id);
    return unrwapUser(user, id);
  }

  @Override
  public User getUser(String username) {
    Optional<User> user = userRepository.findByUsername(username);
    return unrwapUser(user, 404L);
  }

  @Override
  public User saveUser(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  public static User unrwapUser(Optional<User> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new EntityNotFoundException(id, User.class);
  }
}
