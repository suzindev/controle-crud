package br.com.suzintech.controle.domain;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ApiError(
        HttpStatus status,
        String message,
        List<ApiValidation> validations
) {
    public ApiError(HttpStatus status, String message) {
        this(status, message, List.of());
    }

    public ApiError(HttpStatus status, List<ApiValidation> validations) {
        this(status, "", validations);
    }
}
