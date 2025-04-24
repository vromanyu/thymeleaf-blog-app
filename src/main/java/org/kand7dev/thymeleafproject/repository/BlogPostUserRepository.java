package org.kand7dev.thymeleafproject.repository;

import org.kand7dev.thymeleafproject.entity.BlogPostUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogPostUserRepository extends JpaRepository<BlogPostUser, Long> {
 Optional<BlogPostUser> findByEmail(String email);
}
