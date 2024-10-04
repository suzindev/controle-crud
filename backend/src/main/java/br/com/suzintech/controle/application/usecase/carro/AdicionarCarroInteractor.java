package br.com.suzintech.controle.application.usecase.carro;

import br.com.suzintech.controle.application.gateway.CarroGateway;
import br.com.suzintech.controle.domain.Carro;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdicionarCarroInteractor {

    private final CarroGateway carroGateway;

    public String execute(Carro carro) {
        return carroGateway.create(carro);
    }
}
