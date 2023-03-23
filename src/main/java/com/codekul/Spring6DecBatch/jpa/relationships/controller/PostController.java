package com.codekul.Spring6DecBatch.jpa.relationships.controller;

import com.codekul.Spring6DecBatch.jpa.relationships.dto.request.PostRequestDto;
import com.codekul.Spring6DecBatch.jpa.relationships.entity.Post;
import com.codekul.Spring6DecBatch.jpa.relationships.service.PostService;
import com.codekul.Spring6DecBatch.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public Map<String,Object> savePost(@RequestBody PostRequestDto postRequestDto){
        return postService.savePost(postRequestDto);
    }

    @GetMapping("/getPost/{postId}")
    public ResponseEntity<?> getPost(@PathVariable("postId") Long postId){
        return postService.getPostById(postId);
    }

}
