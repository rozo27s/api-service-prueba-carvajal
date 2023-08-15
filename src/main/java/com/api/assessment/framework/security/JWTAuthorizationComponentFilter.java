package com.api.assessment.framework.security;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.assessment.framework.constants.ConfigurationConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTAuthorizationComponentFilter extends OncePerRequestFilter {

  @Value(ConfigurationConstants.SECRET_KEY)
  private String secretKey;
  
  private static final String HEADER = "Authorization";
  private static final String PREFIX = "Bearer ";

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    try {
      if (existeJWTToken(request)) {
        Claims claims = validateToken(request);
        setUpSpringAuthentication(claims);
      } else {
        SecurityContextHolder.clearContext();
      }
      chain.doFilter(request, response);
    } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      (response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
    }
  }

  private Claims validateToken(HttpServletRequest request) {
    String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
    return validateToken(jwtToken);
  }

  public Claims validateToken(String jwtToken) {
    String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
    Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), 
                                    SignatureAlgorithm.HS256.getJcaName());

    Jws<Claims> jwt = Jwts.parserBuilder()
            .setSigningKey(hmacKey)
            .build()
            .parseClaimsJws(jwtToken);

    return jwt.getBody();
  }

  private void setUpSpringAuthentication(Claims claims) {
    List<String> authorities = new ArrayList<>();
    authorities.add("ADMIN");
    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
        authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    SecurityContextHolder.getContext().setAuthentication(auth);

  }

  private boolean existeJWTToken(HttpServletRequest request) {
    String authenticationHeader = request.getHeader(HEADER);
    return !(authenticationHeader == null || !authenticationHeader.startsWith(PREFIX));
  }

}