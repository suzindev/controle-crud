package br.com.suzintech.controle.infra.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MarcaRequest(
        @NotBlank(message = "Este campo é obrigatório")
        @Size(max = 80, message = "O valor máximo permitido é {max} caracteres")
        String nome
) {
}
