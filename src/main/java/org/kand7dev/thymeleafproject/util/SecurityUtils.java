package org.kand7dev.thymeleafproject.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Objects;
import java.util.stream.Collectors;

public class SecurityUtils {

 public static User getCurrentUser() {
  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  if (principal instanceof User user) {
   return user;
  }
  return null;
 }

 public static String getCurrentUserRole(){
  User user = getCurrentUser();
  return Objects.requireNonNull(user).getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
 }
}
