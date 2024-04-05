package com.ifmt.seedlingNursery.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecretConsts {

  @Value("${spring.datasource.secret-key}")
  public String secretKey;

  @Value("${spring.datasource.admin-pass}")
  public String adminPass;
}
