package org.kand7dev.thymeleafproject.service;

import lombok.RequiredArgsConstructor;
import org.kand7dev.thymeleafproject.dto.CommentDto;
import org.kand7dev.thymeleafproject.entity.Comment;
import org.kand7dev.thymeleafproject.entity.Post;
import org.kand7dev.thymeleafproject.mapper.CommentMapper;
import org.kand7dev.thymeleafproject.repository.CommentRepository;
import org.kand7dev.thymeleafproject.repository.PostRepository;
import org.kand7dev.thymeleafproject.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

 @Override
 public List<CommentDto> findAllComments() {
  return commentRepository.findAll().stream().map(CommentMapper::mapToCommentDto).collect(Collectors.toList());
 }

 @Override
 public List<CommentDto> findAllCommentsForLoggedInUser() {
  String email = Objects.requireNonNull(SecurityUtils.getCurrentUser()).getUsername();
  return commentRepository.findCommentsByPost_BlogPostUser_Email(email).stream().map(CommentMapper::mapToCommentDto).collect(Collectors.toList());
 }

 @Override
 public void deleteCommentById(long id) {
  commentRepository.deleteById(id);
 }

}
