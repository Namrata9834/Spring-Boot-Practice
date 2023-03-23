package com.codekul.Spring6DecBatch.jpa.relationships.dto.request;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private String comment;
    private Long postId;
    //private Post post;
}
