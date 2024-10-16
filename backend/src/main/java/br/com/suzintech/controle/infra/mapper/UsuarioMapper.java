package br.com.suzintech.controle.infra.mapper;

import br.com.suzintech.controle.domain.Usuario;
import br.com.suzintech.controle.infra.persistence.entity.UsuarioEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

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

    public UserDetails toUserDetails(UsuarioEntity entity) {
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return entity.getAuthorities();
            }

            @Override
            public String getPassword() {
                return entity.getPassword();
            }

            @Override
            public String getUsername() {
                return entity.getUsername();
            }
        };
    }
}
