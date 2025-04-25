package org.kand7dev.thymeleafproject.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

import java.util.Collections;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SpringSecurityConfiguration {

 private final CustomUserDetailsService customUserDetailsService;

 @Bean
 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
  CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();
  return http.csrf(csrfConfig ->
    csrfConfig.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
     .csrfTokenRequestHandler(csrfTokenRequestAttributeHandler))
   .sessionManagement(session ->
    session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
   .securityContext(securityContext ->
    securityContext.requireExplicitSave(false))
   .authorizeHttpRequests(requests ->
    requests.requestMatchers("/register/**").permitAll()
     .requestMatchers("/admin/**").hasAnyRole("ADMIN", "USER")
     .requestMatchers("/**", "/post/**", "/page/**").permitAll()
   )
   .formLogin(form ->
    form.loginPage("/login")
     .defaultSuccessUrl("/admin/posts", true)
     .loginProcessingUrl("/login")
     .permitAll())
   .logout(logout ->
    logout.logoutUrl("/logout").permitAll()
     .invalidateHttpSession(true).clearAuthentication(true))
//   .addFilterAfter(new CsrfTokenFilter(), BasicAuthenticationFilter.class)
   .build();
 }

 @Bean
 public AuthenticationManager authenticationManager() {
  return new ProviderManager(Collections.singletonList(new CustomAuthenticationProvider(customUserDetailsService, passwordEncoder())));
 }

 @Bean
 public PasswordEncoder passwordEncoder() {
  return PasswordEncoderFactories.createDelegatingPasswordEncoder();
 }

}
