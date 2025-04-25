package org.kand7dev.thymeleafproject.repository;

import org.kand7dev.thymeleafproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
 Optional<Post> findByUrl(String url);

 @Query("select p from Post p where (upper(p.title) like '%' || upper(:query) || '%') or (upper(p.shortDescription) like '%' || upper(:query) || '%')")
 List<Post> searchAllPostsByTitleOrShortDescription(String query);

 @Query("select p from Post p where p.blogPostUser.email = :email and ((upper(p.title) like '%' || upper(:query) || '%') or (upper(p.shortDescription) like '%' || upper(:query) || '%'))")
 List<Post> searchAllPostsByTitleOrShortDescriptionForCurrentUser(String query, String email);

 List<Post> findAllByBlogPostUser_Email(String email);
}
