package com.codekul.Spring6DecBatch.jpa.relationships.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

public interface CommentsResponse {
    Long getId();
    String getComment();
    LocalDate getCommentDate();
    LocalTime getCommentTime();
}
