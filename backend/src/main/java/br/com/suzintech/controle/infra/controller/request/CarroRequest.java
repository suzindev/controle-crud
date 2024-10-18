package br.com.suzintech.controle.infra.controller.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CarroRequest(
        @NotBlank(message = "Este campo é obrigatório")
        @Max(value = 80, message = "O valor máximo permitido é {value} caracteres")
        String nome,

        @NotNull(message = "Este campo é obrigatório")
        Integer ano,

        @NotNull(message = "Este campo é obrigatório")
        Long idMarca,

        List<Long> idsAcessorios
) {
}
