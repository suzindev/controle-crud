package br.com.suzintech.controle.application.usecase.carro;

import br.com.suzintech.controle.application.gateway.CarroGateway;
import br.com.suzintech.controle.domain.Carro;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlterarCarroInteractor {

    private final CarroGateway carroGateway;

    public String execute(Carro carro, Long id) {
        return carroGateway.update(carro, id);
    }
}
