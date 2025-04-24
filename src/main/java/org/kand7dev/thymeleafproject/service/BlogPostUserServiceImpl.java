package org.kand7dev.thymeleafproject.service;

import lombok.RequiredArgsConstructor;
import org.kand7dev.thymeleafproject.dto.BlogPostUserDto;
import org.kand7dev.thymeleafproject.entity.BlogPostUser;
import org.kand7dev.thymeleafproject.repository.BlogPostUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogPostUserServiceImpl implements BlogPostUserService {

 private final BlogPostUserRepository blogPostUserRepository;

 @Override
 public void saveUser(BlogPostUserDto blogPostUserDto) {
  BlogPostUser blogPostUser = new BlogPostUser();
  blogPostUser.setName(blogPostUserDto.getFirstName() + " " + blogPostUserDto.getLastName());
  blogPostUser.setEmail(blogPostUserDto.getEmail());
  blogPostUser.setPassword(blogPostUserDto.getPassword());
  blogPostUser.setRole("USER");
  blogPostUserRepository.save(blogPostUser);
 }

 @Override
 public boolean userWithEmailDoesntExist(String email) {
  Optional<BlogPostUser> user = blogPostUserRepository.findByEmail(email);
  return user.isEmpty();
 }

}
