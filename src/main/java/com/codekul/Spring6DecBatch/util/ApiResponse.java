package com.codekul.Spring6DecBatch.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
public class ApiResponse<T> {
    private String message;
    private Integer status;
    private T result;
}
