package com.ifmt.seedlingNursery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedHeaders("*") // Allow all headers
            .exposedHeaders("*") // Expose all headers
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify the HTTP methods allowed
            .allowedOrigins("*"); // Allow requests from any origin
      }
    };
  }
}
