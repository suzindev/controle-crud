package br.com.suzintech.controle.application.gateway;

import br.com.suzintech.controle.domain.Usuario;

import java.util.List;

public interface UsuarioGateway {

    String create(Usuario request);

    String update(Usuario request, Long id);

    String delete(Long id);

    List<Usuario> findAll();

    Usuario findById(Long id);
}
