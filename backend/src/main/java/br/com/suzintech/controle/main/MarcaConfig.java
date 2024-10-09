package br.com.suzintech.controle.main;

import br.com.suzintech.controle.application.gateway.MarcaGateway;
import br.com.suzintech.controle.application.usecase.marca.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarcaConfig {

    @Bean
    AdicionarMarcaInteractor createMarcaUseCase(MarcaGateway gateway) {
        return new AdicionarMarcaInteractor(gateway);
    }

    @Bean
    AlterarMarcaInteractor updateMarcaUseCase(MarcaGateway gateway) {
        return new AlterarMarcaInteractor(gateway);
    }

    @Bean
    RemoverMarcaInteractor deleteMarcaUseCase(MarcaGateway gateway) {
        return new RemoverMarcaInteractor(gateway);
    }

    @Bean
    ConsultarTodosMarcaInteractor getAllMarcaUseCase(MarcaGateway gateway) {
        return new ConsultarTodosMarcaInteractor(gateway);
    }

    @Bean
    ConsultarMarcaPorIdInteractor getByIdMarcaUseCase(MarcaGateway gateway) {
        return new ConsultarMarcaPorIdInteractor(gateway);
    }
}
