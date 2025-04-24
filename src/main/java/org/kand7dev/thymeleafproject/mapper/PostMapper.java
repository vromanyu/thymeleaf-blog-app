package org.kand7dev.thymeleafproject.mapper;

import org.kand7dev.thymeleafproject.dto.PostDto;
import org.kand7dev.thymeleafproject.entity.Post;

import java.util.stream.Collectors;

public class PostMapper {

 public static PostDto mapToPostDto(Post post) {
  PostDto postDto = new PostDto();
  postDto.setId(post.getId());
  postDto.setTitle(post.getTitle());
  postDto.setContent(post.getContent());
  postDto.setUrl(post.getUrl());
  postDto.setShortDescription(post.getShortDescription());
  postDto.setCreatedAt(post.getCreatedAt());
  postDto.setUpdatedAt(post.getUpdatedAt());
  postDto.setComments(post.getComments().stream().map(CommentMapper::mapToCommentDto).collect(Collectors.toList()));
  return postDto;
 }

 public static Post mapToPost(PostDto postDto) {
  Post post = new Post();
  post.setId(postDto.getId());
  post.setTitle(postDto.getTitle());
  post.setContent(postDto.getContent());
  post.setUrl(postDto.getUrl());
  post.setShortDescription(postDto.getShortDescription());
  post.setCreatedAt(postDto.getCreatedAt());
  post.setUpdatedAt(postDto.getUpdatedAt());
  return post;
 }

}
