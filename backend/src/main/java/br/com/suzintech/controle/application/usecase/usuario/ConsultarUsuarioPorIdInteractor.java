package br.com.suzintech.controle.application.usecase.usuario;

import br.com.suzintech.controle.application.gateway.UsuarioGateway;
import br.com.suzintech.controle.domain.Usuario;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsultarUsuarioPorIdInteractor {

    private final UsuarioGateway gateway;

    public Usuario execute(Long id) {
        return gateway.findById(id);
    }
}
