package org.kand7dev.thymeleafproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.kand7dev.thymeleafproject.dto.PostDto;
import org.kand7dev.thymeleafproject.service.PostService;
import org.kand7dev.thymeleafproject.util.PostUtility;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
 public String savePost(@Valid @ModelAttribute("post") PostDto postDto, BindingResult result, Model model) {
  if (result.hasErrors()) {
   model.addAttribute("post", postDto);
   return "admin/save_post";
  }
  postDto.setUrl(PostUtility.getUrl(postDto.getTitle()));
  postService.save(postDto);
  return "redirect:/admin/posts";
 }

 @GetMapping("/admin/posts/new")
 public String newPost(Model model) {
  model.addAttribute("post", new PostDto());
  return "admin/save_post";
 }

 @GetMapping("/admin/posts/edit/{id}")
 public String editPost(@PathVariable long id, Model model) {
  PostDto post = postService.findPostById(id);
  model.addAttribute("post", post);
  return "admin/save_post";
 }

 @GetMapping("/admin/posts/delete/{id}")
 public String deletePost(@PathVariable long id) {
  postService.deletePostById(id);
  return "redirect:/admin/posts";
 }

 @GetMapping("/admin/posts/{postUrl}/view")
 public String viewPost(@PathVariable String postUrl, Model model) {
  PostDto post = postService.findPostByUrl(postUrl);
  model.addAttribute("post", post);
  return "admin/view_post";
 }

 @GetMapping("/admin/posts/search")
 public String searchPosts(Model model) {
  
 }
}
