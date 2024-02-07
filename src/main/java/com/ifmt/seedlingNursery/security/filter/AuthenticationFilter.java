package com.ifmt.seedlingNursery.security.filter;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifmt.seedlingNursery.Model.User;
import com.ifmt.seedlingNursery.security.manager.CustomAuthenticationManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  // @Autowires the CustomAuthenticationManager @Component
  private CustomAuthenticationManager customAuthenticationManager;

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {

    try {
      User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
      Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
      System.out.println("\nUser: " + user.getUsername());
      System.out.println("\nPassword: " + user.getPassword());
      return customAuthenticationManager.authenticate(authentication);
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  @Override
  protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException failed) throws IOException, ServletException {
    System.out.println("Autenticação falhou.");
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {
    System.out.println("Autenticado com sucesso.");
  }

}
