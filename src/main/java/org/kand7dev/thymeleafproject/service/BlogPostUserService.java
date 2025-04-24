package org.kand7dev.thymeleafproject.service;

import org.kand7dev.thymeleafproject.dto.BlogPostUserDto;

public interface BlogPostUserService {
 void saveUser(BlogPostUserDto blogPostUserDto);
 boolean userWithEmailDoesntExist(String email);
}
