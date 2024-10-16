package br.com.suzintech.controle.application.usecase.usuario;

import br.com.suzintech.controle.application.gateway.UsuarioGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoverUsuarioInteractor {

    private final UsuarioGateway gateway;

    public String execute(Long id) {
        return gateway.delete(id);
    }
}
