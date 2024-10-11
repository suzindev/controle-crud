package br.com.suzintech.controle.application.usecase.acessorio;

import br.com.suzintech.controle.application.gateway.AcessorioGateway;
import br.com.suzintech.controle.domain.Acessorio;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdicionarAcessorioInteractor {

    private final AcessorioGateway gateway;

    public String execute(Acessorio acessorio) {
        return gateway.create(acessorio);
    }
}
