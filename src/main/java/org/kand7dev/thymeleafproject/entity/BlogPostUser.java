package org.kand7dev.thymeleafproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

 @Column(nullable = false, unique = true)
 private String email;

 @Column(nullable = false)
 private String password;

 private String role = "USER";

 @OneToMany(mappedBy = "blogPostUser")
 private List<Post> posts = new ArrayList<>();

}
