package br.com.suzintech.controle.infra.service;

import br.com.suzintech.controle.application.gateway.UsuarioGateway;
import br.com.suzintech.controle.commom.Constants;
import br.com.suzintech.controle.domain.Usuario;
import br.com.suzintech.controle.exception.CrudException;
import br.com.suzintech.controle.infra.mapper.UsuarioMapper;
import br.com.suzintech.controle.infra.persistence.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UsuarioGateway {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    @Override
    public String create(Usuario usuario) {
        try {
            repository.save(mapper.toEntity(new Usuario(usuario.username(), usuario.password(), usuario.role())));

            return Constants.REGISTRO_SALVO.getValue();
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }

    @Override
    public String update(Usuario usuario, Long id) {
        try {
            findById(id);

            repository.save(mapper.toEntity(new Usuario(id, usuario.username(), usuario.password(), usuario.role())));

            return Constants.REGISTRO_ATUALIZADO.getValue();
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }

    @Override
    public String delete(Long id) {
        try {
            repository.deleteById(id);

            return Constants.REGISTRO_DELETADO.getValue();
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }

    @Override
    public List<Usuario> findAll() {
        try {
            return repository.findAll().stream()
                    .map(mapper::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }

    @Override
    public Usuario findById(Long id) {
        try {
            var entity = repository.findById(id)
                    .orElseThrow(() -> new CrudException(Constants.REGISTRO_NAO_ENCONTRADO.getValue()));

            return mapper.toDTO(entity);
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }
}
