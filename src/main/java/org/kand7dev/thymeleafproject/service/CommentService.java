package org.kand7dev.thymeleafproject.service;

import org.kand7dev.thymeleafproject.dto.CommentDto;

public interface CommentService {
 void saveComment(String postUrl, CommentDto commentDto);
}
