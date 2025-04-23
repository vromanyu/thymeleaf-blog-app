package org.kand7dev.thymeleafproject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {

 private long id;

 @NotEmpty(message = "title can't be empty")
 private String title;

 private String url;

 @NotEmpty(message = "content can't be empty")
 private String content;

 @NotEmpty(message = "short description can't be empty")
 private String shortDescription;

 private LocalDateTime createdAt;
 private LocalDateTime updatedAt;
}
