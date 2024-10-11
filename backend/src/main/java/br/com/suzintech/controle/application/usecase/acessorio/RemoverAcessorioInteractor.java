package br.com.suzintech.controle.application.usecase.acessorio;

import br.com.suzintech.controle.application.gateway.AcessorioGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoverAcessorioInteractor {

    private final AcessorioGateway gateway;

    public String execute(Long id) {
        return gateway.delete(id);
    }
}
