package org.kand7dev.thymeleafproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

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
   .addFilterAfter(new CsrfTokenFilter(), BasicAuthenticationFilter.class)
   .build();
 }

}
