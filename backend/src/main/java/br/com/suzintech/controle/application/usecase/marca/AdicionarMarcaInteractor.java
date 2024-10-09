package br.com.suzintech.controle.application.usecase.marca;

import br.com.suzintech.controle.application.gateway.MarcaGateway;
import br.com.suzintech.controle.domain.Marca;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdicionarMarcaInteractor {

    private final MarcaGateway gateway;

    public String execute(Marca marca) {
        return gateway.create(marca);
    }
}
