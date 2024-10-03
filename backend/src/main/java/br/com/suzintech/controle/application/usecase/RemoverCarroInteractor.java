package br.com.suzintech.controle.application.usecase;

import br.com.suzintech.controle.application.gateway.CarroGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoverCarroInteractor {

    private final CarroGateway carroGateway;

    public String execute(Long id) {
        return carroGateway.delete(id);
    }
}
