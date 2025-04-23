package org.kand7dev.thymeleafproject.repository;

import org.kand7dev.thymeleafproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
