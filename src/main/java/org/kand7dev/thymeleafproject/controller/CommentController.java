package org.kand7dev.thymeleafproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.kand7dev.thymeleafproject.dto.CommentDto;
import org.kand7dev.thymeleafproject.service.CommentService;
import org.kand7dev.thymeleafproject.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CommentController {

 private final CommentService commentService;
 private final PostService postService;

 @PostMapping("/{postUrl}/comments")
 public String saveComment(@PathVariable("postUrl") String postUrl, @Valid @ModelAttribute("comment") CommentDto commentDto, BindingResult bindingResult, Model model) {
  if (bindingResult.hasErrors()) {
   model.addAttribute("comment", commentDto);
   model.addAttribute("post", postService.findPostByUrl(postUrl));
   return "blog/view_post";
  }
  commentService.saveComment(postUrl, commentDto);
  return "redirect:/post/{postUrl}";
 }

}
