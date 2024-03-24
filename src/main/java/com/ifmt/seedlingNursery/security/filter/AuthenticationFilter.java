package com.ifmt.seedlingNursery.security.filter;

import java.io.IOException;
import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.ifmt.seedlingNursery.Model.Users;
import com.ifmt.seedlingNursery.security.SecretConsts;
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
      Users user = new ObjectMapper().readValue(request.getInputStream(), Users.class);
      Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
      // System.out.println("\nUser: " + user.getUsername());
      // System.out.println("\nPassword: " + user.getPassword());
      return customAuthenticationManager.authenticate(authentication);
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  @Override
  protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException failed) throws IOException, ServletException {
    System.out.println("Autenticação falhou.");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.getWriter().write("{\"errorMessage\": \"" + failed.getMessage() + "\"}");
    response.getWriter().flush();
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {
    System.out.println("Autenticado com sucesso.");
    String token = JWT.create()
        .withSubject(authResult.getName())
        .withExpiresAt(new Date(System.currentTimeMillis() + 2700000))
        .sign(Algorithm.HMAC512(SecretConsts.SECRET_KEY));
    response.addHeader("Authorization", "Bearer " + token);
    response.addHeader("Content-Type", "application/json");
    response.getWriter().write("{\n\"username\": \"" + authResult.getName() + "\",\n"
        + "\"authority\": \"" + authResult.getAuthorities().iterator().next().toString() + "\"\n}");
    response.getWriter().flush();
  }

}
