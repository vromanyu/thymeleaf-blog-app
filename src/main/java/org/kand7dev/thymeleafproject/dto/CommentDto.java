package org.kand7dev.thymeleafproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

 private long id;

 private String name;

 private String email;
 
 private String content;

 private LocalDateTime createdAt;

 private LocalDateTime updatedAt;

}
