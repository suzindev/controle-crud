package br.com.suzintech.controle.infra.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(
        @NotBlank(message = "Este campo é obrigatório")
        @Size(max = 8, message = "O valor máximo permitido é {max} caracteres")
        String username,

        @NotBlank(message = "Este campo é obrigatório")
        String password,

        @NotBlank(message = "Este campo é obrigatório")
        @Size(max = 8, message = "O valor máximo permitido é {max} caracteres")
        String role
) {
}
