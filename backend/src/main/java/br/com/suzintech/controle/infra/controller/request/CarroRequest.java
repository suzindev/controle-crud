package br.com.suzintech.controle.infra.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CarroRequest(
        @NotBlank(message = "Este campo é obrigatório")
        @Size(max = 80, message = "O valor máximo permitido é {max} caracteres")
        String nome,

        @NotNull(message = "Este campo é obrigatório")
        Integer ano,

        @NotNull(message = "Este campo é obrigatório")
        Long idMarca,

        List<Long> idsAcessorios
) {
}
