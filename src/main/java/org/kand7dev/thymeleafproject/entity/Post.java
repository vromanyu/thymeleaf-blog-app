package org.kand7dev.thymeleafproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;

 @Column(nullable = false)
 private String title;

 private String url;

 @Column(nullable = false)
 private String content;

 private String shortDescription;

 @CreationTimestamp(source = SourceType.DB)
 private LocalDateTime createdAt;

 @UpdateTimestamp(source = SourceType.DB)
 private LocalDateTime updatedAt;

 public Post(String title, String url, String content, String shortDescription) {
  this.title = title;
  this.url = url;
  this.content = content;
  this.shortDescription = shortDescription;
 }

}
