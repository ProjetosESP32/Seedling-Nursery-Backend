package com.ifmt.seedlingNursery.security.filter;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.ifmt.seedlingNursery.exception.EntityNotFoundException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      filterChain.doFilter(request, response);
    } catch (EntityNotFoundException e) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      response.getWriter().write(e.getMessage());
      response.getWriter().flush();
    } catch (JWTVerificationException e) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.addHeader("Content-Type", "text/plain");
      response.getWriter().write("Token invalido.");
      response.getWriter().flush();
    } catch (RuntimeException e) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.getWriter().write(e.getMessage());
      response.getWriter().flush();
    }
  }
}
