package org.kand7dev.thymeleafproject.controller;

import lombok.AllArgsConstructor;
import org.kand7dev.thymeleafproject.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class BlogController {

 private final PostService postService;

 @GetMapping("/")
 public String viewBlogPosts(Model model){
  model.addAttribute("posts", postService.findAllPosts());
  return "blog/view_posts";
 }

}
