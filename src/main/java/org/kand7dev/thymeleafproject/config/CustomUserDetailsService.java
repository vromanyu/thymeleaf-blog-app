package org.kand7dev.thymeleafproject.config;

import lombok.RequiredArgsConstructor;
import org.kand7dev.thymeleafproject.entity.BlogPostUser;
import org.kand7dev.thymeleafproject.repository.BlogPostUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

 private final BlogPostUserRepository blogPostUserRepository;

 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  BlogPostUser blogPostUser = blogPostUserRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
  return User.builder().username(blogPostUser.getEmail()).password(blogPostUser.getPassword()).roles(blogPostUser.getRole()).build();
 }
}
