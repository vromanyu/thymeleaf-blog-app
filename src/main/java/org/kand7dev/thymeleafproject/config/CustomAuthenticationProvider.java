package org.kand7dev.thymeleafproject.config;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

 private final CustomUserDetailsService customUserDetailsService;
 private final PasswordEncoder passwordEncoder;

 @Override
 public Authentication authenticate(Authentication authentication) throws AuthenticationException {
  UserDetails user = customUserDetailsService.loadUserByUsername(authentication.getName());
  if (passwordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
   return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
  } else throw new BadCredentialsException("bad credentials");
 }

 @Override
 public boolean supports(Class<?> authentication) {
  return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
 }
}
