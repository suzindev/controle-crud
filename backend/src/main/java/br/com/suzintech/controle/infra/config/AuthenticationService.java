package br.com.suzintech.controle.infra.config;

import br.com.suzintech.controle.commom.Constants;
import br.com.suzintech.controle.exception.CrudException;
import br.com.suzintech.controle.infra.mapper.UsuarioMapper;
import br.com.suzintech.controle.infra.persistence.entity.UsuarioEntity;
import br.com.suzintech.controle.infra.persistence.repository.UsuarioRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    @Value("${api.security.token.secret}")
    private String secret;

    private final UsuarioRepository repository;

    private final UsuarioMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return mapper.toUserDetails(repository.findByUsername(username)
                .orElseThrow(() -> new CrudException(Constants.USUARIO_NAO_ENCONTRADO.getValue())));
    }

    public String gerarToken(UsuarioEntity entity) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("controle-service")
                    .withSubject(entity.getUsername())
                    .withExpiresAt(gerarDataExpiracao())
                    .withClaim("username", entity.getUsername())
                    .withClaim("id", entity.getId())
                    .withClaim("role", entity.getRole())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new JWTCreationException("Erro ao tentar gerar o token.", e);
        }
    }

    public String validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("controle-service")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

    private Instant gerarDataExpiracao() {
        return LocalDateTime.now()
                .plusHours(1)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
