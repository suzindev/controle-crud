package br.com.suzintech.controle.application.usecase.marca;

import br.com.suzintech.controle.application.gateway.MarcaGateway;
import br.com.suzintech.controle.domain.Marca;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ConsultarTodosMarcaInteractor {

    private final MarcaGateway gateway;

    public List<Marca> execute() {
        return gateway.findAll();
    }
}
