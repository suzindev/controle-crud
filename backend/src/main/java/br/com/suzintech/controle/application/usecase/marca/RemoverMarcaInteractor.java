package br.com.suzintech.controle.application.usecase.marca;

import br.com.suzintech.controle.application.gateway.MarcaGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoverMarcaInteractor {

    private final MarcaGateway gateway;

    public String execute(Long id) {
        return gateway.delete(id);
    }
}
