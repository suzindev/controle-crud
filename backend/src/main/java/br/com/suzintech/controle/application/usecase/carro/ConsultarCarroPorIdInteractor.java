package br.com.suzintech.controle.application.usecase.carro;

import br.com.suzintech.controle.application.gateway.CarroGateway;
import br.com.suzintech.controle.domain.Carro;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsultarCarroPorIdInteractor {

    private final CarroGateway carroGateway;

    public Carro execute(Long id) {
        return carroGateway.findById(id);
    }
}
