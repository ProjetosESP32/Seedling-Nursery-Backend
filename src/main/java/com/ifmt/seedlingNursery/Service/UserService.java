package com.ifmt.seedlingNursery.Service;

import com.ifmt.seedlingNursery.Model.User;

public interface UserService {
  User getUser(Long id);

  User getUser(String username);

  User saveUser(User user);

}
