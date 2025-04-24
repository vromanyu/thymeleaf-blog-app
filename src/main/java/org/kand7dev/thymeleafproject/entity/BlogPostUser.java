package org.kand7dev.thymeleafproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BlogPostUser {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;

 @Column(nullable = false)
 private String name;

 @Column(nullable = false)
 private String email;

 @Column(nullable = false)
 private String password;

 private String role = "USER";

}
