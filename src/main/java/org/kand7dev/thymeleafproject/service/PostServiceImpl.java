package org.kand7dev.thymeleafproject.service;

import lombok.RequiredArgsConstructor;
import org.kand7dev.thymeleafproject.dto.PostDto;
import org.kand7dev.thymeleafproject.entity.BlogPostUser;
import org.kand7dev.thymeleafproject.entity.Post;
import org.kand7dev.thymeleafproject.mapper.PostMapper;
import org.kand7dev.thymeleafproject.repository.BlogPostUserRepository;
import org.kand7dev.thymeleafproject.repository.PostRepository;
import org.kand7dev.thymeleafproject.util.Role;
import org.kand7dev.thymeleafproject.util.SecurityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

 private final PostRepository postRepository;
 private final BlogPostUserRepository blogPostUserRepository;

 @Override
 public List<PostDto> findAllPosts() {
  return postRepository.findAll().stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());
 }

 @Override
 public List<PostDto> findAllPostsByLoggedInUser() {
  String email = Objects.requireNonNull(SecurityUtils.getCurrentUser()).getUsername();
  return postRepository.findAllByBlogPostUser_Email(email).stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());
 }

 @Override
 public void save(PostDto postDto) {
  String email = Objects.requireNonNull(SecurityUtils.getCurrentUser()).getUsername();
  BlogPostUser user = blogPostUserRepository.findByEmail(email).orElse(null);
  Post post = PostMapper.mapToPost(postDto);
  post.setBlogPostUser(user);
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
 public List<PostDto> searchPosts(String title) {
  User user = Objects.requireNonNull(SecurityUtils.getCurrentUser());
  String userRole = SecurityUtils.getCurrentUserRole();
  if (Role.ROLE_ADMIN.name().equals(userRole)) {
   return postRepository.searchAllPostsByTitleOrShortDescription(title).stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());
  } else {
   return postRepository.searchAllPostsByTitleOrShortDescriptionForCurrentUser(title, user.getUsername()).stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());
  }
 }

}
