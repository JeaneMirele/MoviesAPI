package com.movies.api.dto;

import lombok.Data;


@Data
public class ErrorResponseDto {
        private int statusCode;
        private String message;
        private String error;
        private String path;

        public ErrorResponseDto(int statusCode, String message, String error, String path) {
            this.statusCode = statusCode;
            this.message = message;
            this.error = error;
            this.path = path;
        }

}
