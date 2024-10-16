package br.com.suzintech.controle.infra.config;

import br.com.suzintech.controle.infra.persistence.entity.UsuarioEntity;
import br.com.suzintech.controle.infra.persistence.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class InicializaDados implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    @Value("${app.login.admin}")
    private String loginAdmin;

    @Value("${app.senha.admin}")
    private String senhaAdmin;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var admin = usuarioRepository.findByUsername(loginAdmin)
                .orElse(UsuarioEntity.builder()
                        .username(loginAdmin)
                        .password(passwordEncoder.encode(senhaAdmin))
                        .role("ADMIN")
                        .build());

        if (Objects.isNull(admin.getId()))
            usuarioRepository.save(admin);
    }
}
