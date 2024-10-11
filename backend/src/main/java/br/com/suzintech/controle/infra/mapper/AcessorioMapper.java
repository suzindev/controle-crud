package br.com.suzintech.controle.infra.mapper;

import br.com.suzintech.controle.domain.Acessorio;
import br.com.suzintech.controle.infra.persistence.entity.AcessorioEntity;
import org.springframework.stereotype.Component;

@Component
public class AcessorioMapper {

    public AcessorioEntity toEntity(Acessorio dto) {
        return AcessorioEntity.builder()
                .id(dto.id())
                .nome(dto.nome())
                .build();
    }

    public Acessorio toDTO(AcessorioEntity entity) {
        return new Acessorio(entity.getId(), entity.getNome());
    }
}
