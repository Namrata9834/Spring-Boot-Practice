package com.codekul.Spring6DecBatch.jpa.relationships.service;

import com.codekul.Spring6DecBatch.jpa.relationships.dto.request.CommentRequestDto;
import com.codekul.Spring6DecBatch.jpa.relationships.entity.Comments;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CommentService {
    Map<String,Object> saveComment(CommentRequestDto commentRequestDto);

    ResponseEntity<?> getCommentsByPost(Long postId);
}
