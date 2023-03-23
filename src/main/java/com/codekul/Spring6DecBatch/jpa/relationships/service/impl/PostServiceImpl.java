package com.codekul.Spring6DecBatch.jpa.relationships.service.impl;

import com.codekul.Spring6DecBatch.jpa.relationships.dto.request.PostRequestDto;
import com.codekul.Spring6DecBatch.jpa.relationships.entity.Post;
import com.codekul.Spring6DecBatch.jpa.relationships.repository.CommentRepository;
import com.codekul.Spring6DecBatch.jpa.relationships.repository.PostRepository;
import com.codekul.Spring6DecBatch.jpa.relationships.service.PostService;
import com.codekul.Spring6DecBatch.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.codekul.Spring6DecBatch.util.Constants.MESSAGE;
import static com.codekul.Spring6DecBatch.util.Constants.STATUS;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;


    @Override
    public Map<String, Object> savePost(PostRequestDto postRequestDto) {
        Map<String,Object> map = new HashMap<>();
        Post post = new Post();
        post.setPost(postRequestDto.getPost());
        post.setPostDate(LocalDate.now());
        map.put(MESSAGE,"Post saved successfully");
        map.put(STATUS, HttpStatus.CREATED);
        postRepository.save(post);
        return map;
    }

    @Override
    public ResponseEntity<?> getPostById(Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        ApiResponse apiResponse = new ApiResponse();
        if (postOptional.isPresent()){
            apiResponse.setMessage("Get Post by id");
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setResult(postOptional.get());
            return ResponseEntity.ok(apiResponse);

        }else {
            apiResponse.setMessage("Post with ID "+postId + " is not present");
            apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
        }
    }
}
