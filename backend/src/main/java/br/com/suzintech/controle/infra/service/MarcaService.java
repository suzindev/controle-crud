package br.com.suzintech.controle.infra.service;

import br.com.suzintech.controle.application.gateway.MarcaGateway;
import br.com.suzintech.controle.commom.Constants;
import br.com.suzintech.controle.domain.Marca;
import br.com.suzintech.controle.exception.CrudException;
import br.com.suzintech.controle.infra.mapper.MarcaMapper;
import br.com.suzintech.controle.infra.persistence.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class MarcaService implements MarcaGateway {

    private final MarcaRepository repository;
    private final MarcaMapper mapper;

    @Override
    public String create(Marca marca) {
        try {
            repository.save(mapper.toEntity(new Marca(marca.nome())));

            return Constants.REGISTRO_SALVO.getValue();
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }

    @Override
    public String update(Marca marca, Long id) {
        try {
            findById(id);

            repository.save(mapper.toEntity(new Marca(id, marca.nome())));

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
    public List<Marca> findAll() {
        try {
            return repository.findAll().stream()
                    .map(mapper::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }

    @Override
    public Marca findById(Long id) {
        try {
            var entity = repository.findById(id)
                    .orElseThrow(() -> new CrudException(Constants.REGISTRO_NAO_ENCONTRADO.getValue()));

            return mapper.toDTO(entity);
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }
}
