package com.api.assessment.main;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.assessment.framework.security.JWTAuthorizationComponentFilter;

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
      .addFilterAfter(new JWTAuthorizationComponentFilter(),
                      UsernamePasswordAuthenticationFilter.class)
      .authorizeRequests()
      .antMatchers(HttpMethod.GET, "/login/token").permitAll()
      .antMatchers(HttpMethod.PUT, "/login/update-pass").permitAll()
      .antMatchers(HttpMethod.POST, "/login").permitAll()
      .antMatchers(HttpMethod.POST, "/profile").permitAll()
      .antMatchers(HttpMethod.POST, "/login/remember-pass").permitAll()

//      .antMatchers(HttpMethod.GET, "/publication").permitAll()
//      .antMatchers(HttpMethod.POST, "/publication").permitAll()
//      .antMatchers(HttpMethod.POST, "/reaction").permitAll()
//      .antMatchers(HttpMethod.POST, "/comment").permitAll()
//      .antMatchers(HttpMethod.PUT, "/publication").permitAll()
//      .antMatchers(HttpMethod.DELETE, "/publication/{id}").permitAll()
      .anyRequest()
      .authenticated();
  }
}
