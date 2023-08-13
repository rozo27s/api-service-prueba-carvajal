package com.api.assessment.module.login.controller;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.api.assessment.framework.constants.ConfigurationConstants;
import com.api.assessment.framework.dto.Login;
import com.api.assessment.framework.dto.ProfileDTO;
import com.api.assessment.framework.dto.UpdatePassword;
import com.api.assessment.framework.exception.BadRequestException;
import com.api.assessment.framework.security.JWTAuthorizationFilter;
import com.api.assessment.module.profile.controller.ProfileController;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * @author ajrozo
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class LoginController {
  
  private final ProfileController profileController;
  private final JWTAuthorizationFilter jwtAuthorizationFilter;
  
  @Value(ConfigurationConstants.SECRET_KEY)
  private String secretKey;
  
  public ProfileDTO loginProfile(Login profile) {
    log.info("Autentication for {}", profile.getEmail());
    ProfileDTO profileDTO = profileController.getLogin(profile);
    if (profileDTO != null) {
      profileDTO.setToken(getJWTToken(profile.getEmail(), 5L));
    }
    return profileDTO;
  }

  public void updatePasswordProfile(UpdatePassword updatePassword) {
    try {
      jwtAuthorizationFilter.validateToken(updatePassword.getToken());
      profileController.updatePass(updatePassword);
    } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
      throw new BadRequestException(e.getMessage());
    }
  }

  public Object token() {
    Map<String, String> token = new HashMap<>();
    token.put("token", getJWTToken("", 60L));
    return token;
  }
  
  private String getJWTToken(String username, Long minutes) {

    Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secretKey), 
                                SignatureAlgorithm.HS256.getJcaName());
    
    List<GrantedAuthority> grantedAuthorities = AuthorityUtils
        .commaSeparatedStringToAuthorityList("ADMIN");

    String jwtToken = Jwts.builder()
            .setSubject(username)
            .claim("authorities", grantedAuthorities)
            .setId(UUID.randomUUID().toString())
            .setIssuedAt(Date.from(Instant.now()))
            .setExpiration(Date.from(Instant.now().plus(minutes, ChronoUnit.MINUTES)))
            .signWith(hmacKey)
            .compact();

    return "Bearer " + jwtToken;
  }

}