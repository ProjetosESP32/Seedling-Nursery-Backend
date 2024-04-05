package com.ifmt.seedlingNursery.security.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ifmt.seedlingNursery.security.UserServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@SuppressWarnings("null")
@Component
@AllArgsConstructor
public class JWTAuthorizationFilter extends OncePerRequestFilter {

  private UserServiceImpl userServiceImpl;
  private Environment environment;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String headerAuth = request.getHeader("Authorization");

    if (headerAuth == null || !headerAuth.startsWith("Bearer")) {
      filterChain.doFilter(request, response);
      return;
    }

    String token = headerAuth.replace("Bearer ", "");
    String user = JWT.require(Algorithm.HMAC512(environment.getProperty("spring.datasource.secret-key"))).build()
        .verify(token)
        .getSubject();

    UserDetails userDetails = userServiceImpl.loadUserByUsername(user);
    System.out.println("Authority: " + userDetails.getAuthorities().toString());

    SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
    List<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
    auths.add(authority);

    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
        SecurityContextHolder.getContext().getAuthentication(),
        userDetails.getAuthorities());
    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    filterChain.doFilter(request, response);
  }
}
