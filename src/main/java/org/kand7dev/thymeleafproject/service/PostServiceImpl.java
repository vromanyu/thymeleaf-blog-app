package org.kand7dev.thymeleafproject.service;

import lombok.RequiredArgsConstructor;
import org.kand7dev.thymeleafproject.dto.PostDto;
import org.kand7dev.thymeleafproject.entity.Post;
import org.kand7dev.thymeleafproject.mapper.PostMapper;
import org.kand7dev.thymeleafproject.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

 private final PostRepository postRepository;

 @Override
 public List<PostDto> findAllPosts() {
  return postRepository.findAll().stream().map(PostMapper::mapToPostDto).toList();
 }

 @Override
 public void save(PostDto postDto) {
  Post post = PostMapper.mapToPost(postDto);
  postRepository.save(post);
 }

}
