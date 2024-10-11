package br.com.suzintech.controle.infra.service;

import br.com.suzintech.controle.application.gateway.AcessorioGateway;
import br.com.suzintech.controle.commom.Constants;
import br.com.suzintech.controle.domain.Acessorio;
import br.com.suzintech.controle.exception.CrudException;
import br.com.suzintech.controle.infra.mapper.AcessorioMapper;
import br.com.suzintech.controle.infra.persistence.repository.AcessorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcessorioService implements AcessorioGateway {

    private final AcessorioRepository repository;
    private final AcessorioMapper mapper;

    @Override
    public String create(Acessorio acessorio) {
        try {
            repository.save(mapper.toEntity(new Acessorio(acessorio.nome())));

            return Constants.REGISTRO_SALVO.getValue();
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }

    @Override
    public String update(Acessorio acessorio, Long id) {
        try {
            findById(id);

            repository.save(mapper.toEntity(new Acessorio(id, acessorio.nome())));

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
    public List<Acessorio> findAll() {
        try {
            return repository.findAll().stream()
                    .map(mapper::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }

    @Override
    public Acessorio findById(Long id) {
        try {
            var entity = repository.findById(id)
                    .orElseThrow(() -> new CrudException(Constants.REGISTRO_NAO_ENCONTRADO.getValue()));

            return mapper.toDTO(entity);
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }
}
