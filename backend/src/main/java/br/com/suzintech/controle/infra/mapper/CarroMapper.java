package br.com.suzintech.controle.infra.mapper;

import br.com.suzintech.controle.domain.Carro;
import br.com.suzintech.controle.infra.persistence.entity.CarroEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarroMapper {

    private final MarcaMapper marcaMapper;
    private final AcessorioMapper acessorioMapper;

    public CarroEntity toEntity(Carro dto) {
        return CarroEntity.builder()
                .id(dto.id())
                .nome(dto.nome())
                .ano(dto.ano())
                .marca(marcaMapper.toEntity(dto.marca()))
                .acessorios(dto.acessorios().stream()
                        .map(acessorioMapper::toEntity)
                        .toList())
                .build();
    }

    public Carro toDTO(CarroEntity entity) {
        return new Carro(
                entity.getId(),
                entity.getNome(),
                entity.getAno(),
                marcaMapper.toDTO(entity.getMarca()),
                entity.getAcessorios().stream()
                        .map(acessorioMapper::toDTO)
                        .toList()
        );
    }
}
