package br.com.suzintech.controle.application.usecase.marca;

import br.com.suzintech.controle.application.gateway.MarcaGateway;
import br.com.suzintech.controle.domain.Marca;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsultarMarcaPorIdInteractor {

    private final MarcaGateway gateway;

    public Marca execute(Long id) {
        return gateway.findById(id);
    }
}
