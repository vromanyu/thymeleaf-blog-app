package org.kand7dev.thymeleafproject.service;

import org.kand7dev.thymeleafproject.dto.PostDto;

import java.util.List;

public interface PostService {
 List<PostDto> findAllPosts();
 void save(PostDto postDto);
}
