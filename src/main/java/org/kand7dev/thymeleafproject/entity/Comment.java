package org.kand7dev.thymeleafproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;

 @Column(nullable = false)
 private String name;

 @Column(nullable = false)
 private String email;

 @Lob
 private String content;

 @CreationTimestamp(source = SourceType.DB)
 private LocalDateTime createdAt;

 @UpdateTimestamp(source = SourceType.DB)
 private LocalDateTime updatedAt;

 @ManyToOne
 @JoinColumn
 private Post post;

 public Comment(String name, String email, String content, Post post) {
  this.name = name;
  this.email = email;
  this.content = content;
  this.post = post;
 }

}
