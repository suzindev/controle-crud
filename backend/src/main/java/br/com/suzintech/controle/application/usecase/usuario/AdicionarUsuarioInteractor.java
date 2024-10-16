package br.com.suzintech.controle.application.usecase.usuario;

import br.com.suzintech.controle.application.gateway.UsuarioGateway;
import br.com.suzintech.controle.domain.Usuario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdicionarUsuarioInteractor {

    private final UsuarioGateway gateway;

    public String execute(Usuario usuario) {
        return gateway.create(usuario);
    }
}
