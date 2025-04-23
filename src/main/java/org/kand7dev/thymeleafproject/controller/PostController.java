package org.kand7dev.thymeleafproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.kand7dev.thymeleafproject.dto.PostDto;
import org.kand7dev.thymeleafproject.service.PostService;
import org.kand7dev.thymeleafproject.util.PostUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

 private final PostService postService;

 @GetMapping("/admin/posts")
 public String posts(Model model) {
  model.addAttribute("posts", postService.findAllPosts());
  return "/admin/posts";
 }

 @PostMapping("/admin/posts")
 public String addPost(@Valid @ModelAttribute("post") PostDto postDto, BindingResult result, Model model) {
  if (result.hasErrors()) {
   model.addAttribute("post", postDto);
   return "/admin/create_post";
  }
  postDto.setUrl(PostUtility.getUrl(postDto.getTitle()));
  postService.save(postDto);
  return "redirect:/admin/posts";
 }

 @GetMapping("/admin/posts/new")
 public String newPost(Model model) {
  model.addAttribute("post", new PostDto());
  return "/admin/create_post";
 }
}
