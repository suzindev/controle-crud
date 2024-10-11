package br.com.suzintech.controle.main;

import br.com.suzintech.controle.application.gateway.AcessorioGateway;
import br.com.suzintech.controle.application.usecase.acessorio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AcessorioConfig {

    @Bean
    AdicionarAcessorioInteractor createAcessorioUseCase(AcessorioGateway gateway) {
        return new AdicionarAcessorioInteractor(gateway);
    }

    @Bean
    AlterarAcessorioInteractor updateAcessorioUseCase(AcessorioGateway gateway) {
        return new AlterarAcessorioInteractor(gateway);
    }

    @Bean
    RemoverAcessorioInteractor deleteAcessorioUseCase(AcessorioGateway gateway) {
        return new RemoverAcessorioInteractor(gateway);
    }

    @Bean
    ConsultarTodosAcessorioInteractor getAllAcessorioUseCase(AcessorioGateway gateway) {
        return new ConsultarTodosAcessorioInteractor(gateway);
    }

    @Bean
    ConsultarAcessorioPorIdInteractor getByIdAcessorioUseCase(AcessorioGateway gateway) {
        return new ConsultarAcessorioPorIdInteractor(gateway);
    }
}
