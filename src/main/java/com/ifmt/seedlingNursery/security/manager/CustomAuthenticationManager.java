package com.ifmt.seedlingNursery.security.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ifmt.seedlingNursery.security.UserServiceImpl;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

  private UserServiceImpl userServiceImpl;
  private PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    UserDetails user = userServiceImpl.loadUserByUsername(authentication.getName());
    if (!passwordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
      throw new BadCredentialsException("Senha Incorreta");
    }

    System.out.println("getAuth: " + user.getAuthorities().toString());

    return new UsernamePasswordAuthenticationToken(authentication.getName(), user.getPassword(), user.getAuthorities());
  }

}
