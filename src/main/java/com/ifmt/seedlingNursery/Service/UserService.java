package com.ifmt.seedlingNursery.Service;

import com.ifmt.seedlingNursery.Model.Users;

public interface UserService {
  Users getUser(Long id);

  Users getUser(String username);

  Users saveUser(Users user);

}
