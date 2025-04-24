package org.kand7dev.thymeleafproject.mapper;

import org.kand7dev.thymeleafproject.dto.CommentDto;
import org.kand7dev.thymeleafproject.entity.Comment;

public class CommentMapper {

 public static CommentDto mapToCommentDto(Comment comment){
  CommentDto commentDto = new CommentDto();
  commentDto.setId(comment.getId());
  commentDto.setName(comment.getName());
  commentDto.setEmail(comment.getEmail());
  commentDto.setContent(comment.getContent());
  commentDto.setPostUrl(comment.getPost().getUrl());
  commentDto.setCreatedAt(comment.getCreatedAt());
  commentDto.setUpdatedAt(comment.getUpdatedAt());
  return commentDto;
 }

 public static Comment mapToComment(CommentDto commentDto){
  Comment comment = new Comment();
  comment.setId(commentDto.getId());
  comment.setName(commentDto.getName());
  comment.setEmail(commentDto.getEmail());
  comment.setContent(commentDto.getContent());
  comment.setCreatedAt(commentDto.getCreatedAt());
  comment.setUpdatedAt(commentDto.getUpdatedAt());
  return comment;
 }

}
