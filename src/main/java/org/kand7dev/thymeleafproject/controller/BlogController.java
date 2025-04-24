package org.kand7dev.thymeleafproject.controller;

import lombok.AllArgsConstructor;
import org.kand7dev.thymeleafproject.dto.CommentDto;
import org.kand7dev.thymeleafproject.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class BlogController {

 private final PostService postService;

 @GetMapping("/")
 public String viewBlogPosts(Model model){
  model.addAttribute("posts", postService.findAllPosts());
  return "blog/view_posts";
 }

 @GetMapping("/post/{postUrl}")
 public String viewPost(@PathVariable String postUrl, Model model){
  model.addAttribute("post", postService.findPostByUrl(postUrl));
  model.addAttribute("comment", new CommentDto());
  return "blog/view_post";
 }

 @GetMapping("/page/search")
 public String searchBlogPosts(@RequestParam("query") String query, Model model){
  model.addAttribute("posts", postService.searchPosts(query));
  return "blog/view_posts";
 }

}
