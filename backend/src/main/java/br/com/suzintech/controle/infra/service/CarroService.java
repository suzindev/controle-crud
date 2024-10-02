package br.com.suzintech.controle.infra.service;

import br.com.suzintech.controle.application.gateway.CarroGateway;
import br.com.suzintech.controle.domain.Carro;
import br.com.suzintech.controle.infra.mapper.CarroMapper;
import br.com.suzintech.controle.infra.persistence.repository.CarroRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarroService implements CarroGateway {

    private final CarroRepository repository;
    private final CarroMapper mapper;

    @Override
    public Carro create(Carro carro) {
        var entity = mapper.toEntity(carro);
        var savedEntity = repository.save(entity);

        return mapper.toDTO(savedEntity);
    }
}
