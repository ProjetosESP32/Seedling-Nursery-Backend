package com.ifmt.seedlingNursery.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

  private BCryptPasswordEncoder passwordEncoder;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // it seems that the upper rulles have preference.
    http
        .csrf().disable() // disables protection against csrf attacks
        .authorizeRequests()
        .requestMatchers("/user/register").hasRole("ADMIN")
        .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
        .requestMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
        .anyRequest().authenticated()
        .and()
        .httpBasic()
        .and()
        // sets to not create session for logged user.
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    return http.build();
  }

  @Bean
  public UserDetailsService users() {
    UserDetails admin = User.builder()
        .username("admin")
        .password(passwordEncoder.encode(SecretConsts.ADMIN_PASS))
        .roles("ADMIN")
        .build();

    UserDetails user1 = User.builder()
        .username("user")
        .password(passwordEncoder.encode(SecretConsts.USER_PASS))
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(admin, user1);
  }
}
