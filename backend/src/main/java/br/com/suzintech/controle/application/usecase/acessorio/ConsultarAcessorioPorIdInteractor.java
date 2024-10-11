package br.com.suzintech.controle.application.usecase.acessorio;

import br.com.suzintech.controle.application.gateway.AcessorioGateway;
import br.com.suzintech.controle.domain.Acessorio;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsultarAcessorioPorIdInteractor {

    private final AcessorioGateway gateway;

    public Acessorio execute(Long id) {
        return gateway.findById(id);
    }
}
