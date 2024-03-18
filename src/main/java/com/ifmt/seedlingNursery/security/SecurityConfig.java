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
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.ifmt.seedlingNursery.security.filter.AuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;
import com.ifmt.seedlingNursery.security.filter.ExceptionHandlerFilter;
import com.ifmt.seedlingNursery.security.filter.JWTAuthorizationFilter;
import com.ifmt.seedlingNursery.security.manager.CustomAuthenticationManager;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

  private BCryptPasswordEncoder passwordEncoder;
  CustomAuthenticationManager customAuthenticationManager;
  JWTAuthorizationFilter jwtAuthorizationFilter;

  @SuppressWarnings("deprecation")
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
    authenticationFilter.setFilterProcessesUrl("/authenticate");
    // it seems that the upper rulles have preference.
    http
        .csrf(csrf -> csrf.disable()) // disables protection against csrf attacks
        .authorizeRequests(requests -> requests
            // .requestMatchers("/user/register/*").permitAll()
            .requestMatchers("/user/register/**").hasAuthority("ADMIN")
            .requestMatchers(HttpMethod.DELETE).hasAuthority("ADMIN")
            .requestMatchers(HttpMethod.POST).hasAnyAuthority("ADMIN", "USER")
            .anyRequest().authenticated())
        // .httpBasic(withDefaults())
        .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
        .addFilter(authenticationFilter)
        .addFilterAfter(jwtAuthorizationFilter, AuthenticationFilter.class)
        // sets to not create session for logged user.
        .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    return http.build();
  }

  // @Bean
  // public UserDetailsService users() {
  // UserDetails admin = User.builder()
  // .username("admin")
  // .password(passwordEncoder.encode(SecretConsts.ADMIN_PASS))
  // .roles("ADMIN")
  // .build();

  // UserDetails user1 = User.builder()
  // .username("user")
  // .password(passwordEncoder.encode(SecretConsts.USER_PASS))
  // .roles("USER")
  // .build();

  // return new InMemoryUserDetailsManager(admin, user1);
  // }
}
