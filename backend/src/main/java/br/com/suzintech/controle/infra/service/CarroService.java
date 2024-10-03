package br.com.suzintech.controle.infra.service;

import br.com.suzintech.controle.application.gateway.CarroGateway;
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
//            var entity = mapper.toEntity(carro);
//            var savedEntity = repository.save(entity);

            return "Carro salvo com sucesso!";
        } catch (Exception e) {
            throw new CrudException("Erro ao salvar o registro: " + e.getMessage());
        }
    }

    @Override
    public String update(Carro carro, Long id) {
        return "";
    }

    @Override
    public String delete(Long id) {
        return "";
    }

    @Override
    public List<Carro> findAll() {
        return List.of();
    }

    @Override
    public Carro findById(Long id) {
        return null;
    }
}
