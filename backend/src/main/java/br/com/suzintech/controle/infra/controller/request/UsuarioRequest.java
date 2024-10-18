package br.com.suzintech.controle.infra.controller.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(
        @NotBlank(message = "Este campo é obrigatório")
        @Max(value = 8, message = "O valor máximo permitido é {value} caracteres")
        String username,

        @NotBlank(message = "Este campo é obrigatório")
        String password,

        @NotBlank(message = "Este campo é obrigatório")
        @Max(value = 8, message = "O valor máximo permitido é {value} caracteres")
        String role
) {
}
