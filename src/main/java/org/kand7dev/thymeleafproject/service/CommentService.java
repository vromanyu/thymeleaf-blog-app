package org.kand7dev.thymeleafproject.service;

import org.kand7dev.thymeleafproject.dto.CommentDto;

import java.util.List;

public interface CommentService {
 void saveComment(String postUrl, CommentDto commentDto);
 List<CommentDto> findAllComments();
 void deleteCommentById(long id);
}
