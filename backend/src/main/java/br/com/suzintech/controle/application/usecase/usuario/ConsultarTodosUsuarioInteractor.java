package br.com.suzintech.controle.application.usecase.usuario;

import br.com.suzintech.controle.application.gateway.UsuarioGateway;
import br.com.suzintech.controle.domain.Usuario;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ConsultarTodosUsuarioInteractor {

    private final UsuarioGateway gateway;

    public List<Usuario> execute() {
        return gateway.findAll();
    }
}
