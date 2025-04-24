package org.kand7dev.thymeleafproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.kand7dev.thymeleafproject.dto.BlogPostUserDto;
import org.kand7dev.thymeleafproject.service.BlogPostUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

 private final BlogPostUserService blogPostUserService;

 @GetMapping("/register")
 public String registrationForm(Model model) {
  model.addAttribute("user", new BlogPostUserDto());
  return "register";
 }

 @PostMapping("/register/save")
 public String saveUser(@Valid @ModelAttribute("user") BlogPostUserDto user, BindingResult bindingResult, Model model) {
  if (!blogPostUserService.userWithEmailDoesntExist(user.getEmail())){
   bindingResult.rejectValue("email", "", "this email already exists");
  }
  if (bindingResult.hasErrors()){
   model.addAttribute("user", user);
   return "register";
  }
  blogPostUserService.saveUser(user);
  return "redirect:/register?success";
 }

 @GetMapping("/login")
 public String loginForm() {
  return "login";
 }
}
