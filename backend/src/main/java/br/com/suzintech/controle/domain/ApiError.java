package br.com.suzintech.controle.domain;

import org.springframework.http.HttpStatus;

public record ApiError(HttpStatus status, String message) {
}
