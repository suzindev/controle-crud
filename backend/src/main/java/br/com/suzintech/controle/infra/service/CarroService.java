package br.com.suzintech.controle.infra.service;

import br.com.suzintech.controle.application.gateway.CarroGateway;
import br.com.suzintech.controle.commom.Constants;
import br.com.suzintech.controle.domain.Carro;
import br.com.suzintech.controle.exception.CrudException;
import br.com.suzintech.controle.infra.mapper.CarroMapper;
import br.com.suzintech.controle.infra.persistence.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarroService implements CarroGateway {

    private final CarroRepository repository;
    private final CarroMapper mapper;

    @Override
    public String create(Carro carro) {
        try {
            repository.save(mapper.toEntity(
                    new Carro(
                            carro.nome(),
                            carro.ano(),
                            carro.marca())
            ));

            return Constants.REGISTRO_SALVO.getValue();
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }

    @Override
    public String update(Carro carro, Long id) {
        try {
            findById(id);

            repository.save(mapper.toEntity(
                    new Carro(
                            id,
                            carro.nome(),
                            carro.ano(),
                            carro.marca())
            ));

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
    public List<Carro> findAll() {
        try {
            return repository.findAll().stream()
                    .map(mapper::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }

    @Override
    public Carro findById(Long id) {
        try {
            var entity = repository.findById(id)
                    .orElseThrow(() -> new CrudException(Constants.REGISTRO_NAO_ENCONTRADO.getValue()));

            return mapper.toDTO(entity);
        } catch (Exception e) {
            throw new CrudException(e.getMessage());
        }
    }
}
