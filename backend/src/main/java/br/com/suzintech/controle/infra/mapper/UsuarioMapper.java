package br.com.suzintech.controle.infra.mapper;

import br.com.suzintech.controle.domain.Usuario;
import br.com.suzintech.controle.infra.config.CustomUserDetails;
import br.com.suzintech.controle.infra.controller.request.UsuarioRequest;
import br.com.suzintech.controle.infra.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioEntity toEntity(Usuario dto) {
        return UsuarioEntity.builder()
                .id(dto.id())
                .username(dto.username())
                .password(dto.password())
                .role(dto.role())
                .build();
    }

    public Usuario toDTO(UsuarioEntity entity) {
        return new Usuario(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getRole());
    }

    public CustomUserDetails toUserDetails(UsuarioEntity entity) {
        return CustomUserDetails.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .role(entity.getRole())
                .build();
    }

    public Usuario toDTO(UsuarioRequest request) {
        return new Usuario(
                request.username(),
                request.password(),
                request.role()
        );
    }
}
