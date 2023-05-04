package com.codekul.Spring6DecBatch.jpa.relationships.repository;

import com.codekul.Spring6DecBatch.jpa.relationships.dto.response.CommentsResponse;
import com.codekul.Spring6DecBatch.jpa.relationships.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface
CommentRepository extends JpaRepository<Comments,Long> {

    @Query(value = " select id,comment,comment_date,comment_time from comments where post_id = ?1",nativeQuery = true)
    List<CommentsResponse> findByPostId(Long postId);
}
