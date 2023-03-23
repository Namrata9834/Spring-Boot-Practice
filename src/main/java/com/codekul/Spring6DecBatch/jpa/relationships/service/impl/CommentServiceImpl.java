package com.codekul.Spring6DecBatch.jpa.relationships.service.impl;

import com.codekul.Spring6DecBatch.jpa.relationships.dto.request.CommentRequestDto;
import com.codekul.Spring6DecBatch.jpa.relationships.dto.response.CommentsResponse;
import com.codekul.Spring6DecBatch.jpa.relationships.entity.Comments;
import com.codekul.Spring6DecBatch.jpa.relationships.entity.Post;
import com.codekul.Spring6DecBatch.jpa.relationships.repository.CommentRepository;
import com.codekul.Spring6DecBatch.jpa.relationships.service.CommentService;
import com.codekul.Spring6DecBatch.util.ApiResponse;
import com.codekul.Spring6DecBatch.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Map<String, Object> saveComment(CommentRequestDto commentRequestDto) {
        Map<String,Object>  map = new HashMap<>();
        map.put(Constants.MESSAGE,"Comment saved successfully");
        map.put(Constants.RESULT, HttpStatus.CREATED);
        Comments comments = new Comments();
        comments.setComment(commentRequestDto.getComment());
        comments.setCommentDate(LocalDate.now());
        comments.setCommentTime(LocalTime.now());
        Post post = new Post();
        post.setId(commentRequestDto.getPostId());
        comments.setPost(post);
        commentRepository.save(comments);
        return map;
    }

    @Override
    public ResponseEntity<?> getCommentsByPost(Long postId) {
        ApiResponse apiResponse = new ApiResponse();
        List<CommentsResponse>comments= commentRepository.findByPostId(postId);
        if (comments.isEmpty()){
            apiResponse.setMessage("No comments available for this post");
            apiResponse.setStatus(HttpStatus.NO_CONTENT.value());
            return new ResponseEntity<>(apiResponse,HttpStatus.NO_CONTENT);
        }else {
            apiResponse.setResult(commentRepository.findByPostId(postId));
            apiResponse.setMessage("Comment List");
            apiResponse.setStatus(HttpStatus.OK.value());
            return ResponseEntity.ok(apiResponse);
        }

    }
}
