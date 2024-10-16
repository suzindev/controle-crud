package br.com.suzintech.controle.application.usecase.usuario;

import br.com.suzintech.controle.application.gateway.UsuarioGateway;
import br.com.suzintech.controle.domain.Usuario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlterarUsuarioInteractor {

    private final UsuarioGateway gateway;

    public String execute(Usuario usuario, Long id) {
        return gateway.update(usuario, id);
    }
}
