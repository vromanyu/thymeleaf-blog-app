package org.kand7dev.thymeleafproject.service;

import lombok.RequiredArgsConstructor;
import org.kand7dev.thymeleafproject.dto.CommentDto;
import org.kand7dev.thymeleafproject.entity.Comment;
import org.kand7dev.thymeleafproject.entity.Post;
import org.kand7dev.thymeleafproject.mapper.CommentMapper;
import org.kand7dev.thymeleafproject.repository.CommentRepository;
import org.kand7dev.thymeleafproject.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

 private final CommentRepository commentRepository;
 private final PostRepository postRepository;


 @Override
 public void saveComment(String postUrl, CommentDto commentDto) {
  Post post = postRepository.findByUrl(postUrl).orElseThrow();
  Comment comment = CommentMapper.mapToComment(commentDto);
  comment.setPost(post);
  commentRepository.save(comment);
 }
 
}
