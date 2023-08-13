package com.api.assessment.main;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.assessment.framework.security.JWTAuthorizationFilter;

/**
 * @author ajrozo
 */
@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
      .addFilterAfter(new JWTAuthorizationFilter(),
                      UsernamePasswordAuthenticationFilter.class)
      .authorizeRequests()
      .antMatchers(HttpMethod.GET, "/login/token").permitAll()
      .antMatchers(HttpMethod.PUT, "/login/update-pass").permitAll()
      .antMatchers(HttpMethod.POST, "/login").permitAll()
      .antMatchers(HttpMethod.POST, "/profile").permitAll()

      .antMatchers(HttpMethod.GET, "/publication").permitAll()
      .antMatchers(HttpMethod.POST, "/publication").permitAll()
      .anyRequest()
      .authenticated();
  }
}
