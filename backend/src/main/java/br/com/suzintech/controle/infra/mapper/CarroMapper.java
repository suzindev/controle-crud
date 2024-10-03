package br.com.suzintech.controle.infra.mapper;

import br.com.suzintech.controle.domain.Carro;
import br.com.suzintech.controle.infra.controller.request.CarroRequest;
import br.com.suzintech.controle.infra.controller.response.CarroResponse;
import br.com.suzintech.controle.infra.persistence.entity.CarroEntity;
import org.springframework.stereotype.Component;

@Component
public class CarroMapper {

    public CarroEntity toEntity(Carro dto) {
        return CarroEntity.builder()
                .nome(dto.nome())
                .ano(dto.ano())
                .build();
    }

    public Carro toDTO(CarroEntity entity) {
        return new Carro(entity.getId(), entity.getNome(), entity.getAno());
    }

    public Carro toDTO(CarroRequest request) {
        return new Carro(request.nome(), request.ano());
    }

    public CarroResponse toResponse(Carro dto) {
        return new CarroResponse(dto);
    }
}
