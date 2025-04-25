package org.kand7dev.thymeleafproject.repository;

import org.kand7dev.thymeleafproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
 List<Comment> findCommentsByPost_BlogPostUser_Email(String email);
}
