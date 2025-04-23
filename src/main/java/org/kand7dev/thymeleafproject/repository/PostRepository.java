package org.kand7dev.thymeleafproject.repository;

import org.kand7dev.thymeleafproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
 Optional<Post> findByUrl(String url);

 List<Post> findByTitleLikeIgnoreCaseOrShortDescriptionLikeIgnoreCase(String title, String shortDescription);
}
