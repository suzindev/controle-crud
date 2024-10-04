package br.com.suzintech.controle.application.usecase.carro;

import br.com.suzintech.controle.application.gateway.CarroGateway;
import br.com.suzintech.controle.domain.Carro;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ConsultarTodosCarroInteractor {

    private final CarroGateway carroGateway;

    public List<Carro> execute() {
        return carroGateway.findAll();
    }
}
