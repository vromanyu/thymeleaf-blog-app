package org.kand7dev.thymeleafproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogPostUserDto {

 private long id;

 @NotEmpty(message = "first name can't be empty")
 private String firstName;

 @NotEmpty(message = "last name can't be empty")
 private String lastName;

 @NotEmpty(message = "email can't be empty")
 @Email
 private String email;

 @NotEmpty(message = "password can't be empty")
 private String password;

}
