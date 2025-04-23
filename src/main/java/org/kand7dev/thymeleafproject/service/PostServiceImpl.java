package org.kand7dev.thymeleafproject.service;

import lombok.RequiredArgsConstructor;
import org.kand7dev.thymeleafproject.dto.PostDto;
import org.kand7dev.thymeleafproject.entity.Post;
import org.kand7dev.thymeleafproject.mapper.PostMapper;
import org.kand7dev.thymeleafproject.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

 private final PostRepository postRepository;

 @Override
 public List<PostDto> findAllPosts() {
  return postRepository.findAll().stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());
 }

 @Override
 public void save(PostDto postDto) {
  Post post = PostMapper.mapToPost(postDto);
  postRepository.save(post);
 }

 @Override
 public PostDto findPostById(long id) {
  Optional<Post> post = postRepository.findById(id);
  return post.map(PostMapper::mapToPostDto).orElseThrow();
 }

 @Override
 public void deletePostById(long id) {
  postRepository.deleteById(id);
 }

 @Override
 public PostDto findPostByUrl(String url) {
  Post post = postRepository.findByUrl(url).orElseThrow();
  return PostMapper.mapToPostDto(post);
 }

 @Override
 public List<PostDto> searchPosts(String title, String shortDescription) {
  return postRepository.findByTitleLikeIgnoreCaseOrShortDescriptionLikeIgnoreCase(title, shortDescription).stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());
 }
 
}
