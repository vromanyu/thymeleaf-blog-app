package org.kand7dev.thymeleafproject.repository;

import org.kand7dev.thymeleafproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
