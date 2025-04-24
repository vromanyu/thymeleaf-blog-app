package org.kand7dev.thymeleafproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

 private long id;

 @NotEmpty(message = "name can't be empty")
 private String name;

 @NotEmpty(message = "email can't be empty")
 @Email(message = "invalid email format")
 private String email;
 
 @NotEmpty(message = "content can't be empty")
 private String content;

 private LocalDateTime createdAt;

 private LocalDateTime updatedAt;

}
