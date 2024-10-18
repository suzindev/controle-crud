package br.com.suzintech.controle.infra.mapper;

import br.com.suzintech.controle.domain.Marca;
import br.com.suzintech.controle.infra.controller.request.MarcaRequest;
import br.com.suzintech.controle.infra.persistence.entity.MarcaEntity;
import org.springframework.stereotype.Component;

@Component
public class MarcaMapper {

    public MarcaEntity toEntity(Marca dto) {
        return MarcaEntity.builder()
                .id(dto.id())
                .nome(dto.nome())
                .build();
    }

    public Marca toDTO(MarcaEntity entity) {
        return new Marca(entity.getId(), entity.getNome());
    }

    public Marca toDTO(MarcaRequest request) {
        return new Marca(request.nome());
    }
}
