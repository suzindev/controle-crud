package br.com.suzintech.controle.infra.controller.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record AcessorioRequest(
        @NotBlank(message = "Este campo é obrigatório")
        @Max(value = 80, message = "O valor máximo permitido é {value} caracteres")
        String nome
) {
}
