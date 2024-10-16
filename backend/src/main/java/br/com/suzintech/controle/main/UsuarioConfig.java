package br.com.suzintech.controle.main;

import br.com.suzintech.controle.application.gateway.UsuarioGateway;
import br.com.suzintech.controle.application.usecase.usuario.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    AdicionarUsuarioInteractor createUsuarioUseCase(UsuarioGateway gateway) {
        return new AdicionarUsuarioInteractor(gateway);
    }

    @Bean
    AlterarUsuarioInteractor updateUsuarioUseCase(UsuarioGateway gateway) {
        return new AlterarUsuarioInteractor(gateway);
    }

    @Bean
    RemoverUsuarioInteractor deleteUsuarioUseCase(UsuarioGateway gateway) {
        return new RemoverUsuarioInteractor(gateway);
    }

    @Bean
    ConsultarTodosUsuarioInteractor getAllUsuarioUseCase(UsuarioGateway gateway) {
        return new ConsultarTodosUsuarioInteractor(gateway);
    }

    @Bean
    ConsultarUsuarioPorIdInteractor getByIdUsuarioUseCase(UsuarioGateway gateway) {
        return new ConsultarUsuarioPorIdInteractor(gateway);
    }
}
