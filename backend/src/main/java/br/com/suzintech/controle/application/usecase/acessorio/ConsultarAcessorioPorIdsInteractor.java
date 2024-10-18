package br.com.suzintech.controle.application.usecase.acessorio;

import br.com.suzintech.controle.application.gateway.AcessorioGateway;
import br.com.suzintech.controle.domain.Acessorio;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ConsultarAcessorioPorIdsInteractor {

    private final AcessorioGateway gateway;

    public List<Acessorio> execute(List<Long> ids) {
        return gateway.findByIds(ids);
    }
}
