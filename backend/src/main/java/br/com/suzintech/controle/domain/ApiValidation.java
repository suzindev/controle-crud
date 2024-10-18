package br.com.suzintech.controle.domain;

public record ApiValidation(
        String field,
        String error
) {
}
