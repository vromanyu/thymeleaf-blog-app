package org.kand7dev.thymeleafproject.service;

import org.kand7dev.thymeleafproject.dto.PostDto;

import java.util.List;

public interface PostService {
 List<PostDto> findAllPosts();

 List<PostDto> findAllPostsByLoggedInUser();

 void save(PostDto postDto);

 PostDto findPostById(long id);

 void deletePostById(long id);

 PostDto findPostByUrl(String url);

 List<PostDto> searchPosts(String title);
}
