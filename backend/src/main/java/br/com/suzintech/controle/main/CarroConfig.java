package br.com.suzintech.controle.main;

import br.com.suzintech.controle.application.gateway.CarroGateway;
import br.com.suzintech.controle.application.usecase.AdicionarCarroInteractor;
import br.com.suzintech.controle.application.usecase.AlterarCarroInteractor;
import br.com.suzintech.controle.application.usecase.RemoverCarroInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarroConfig {

    @Bean
    AdicionarCarroInteractor createUseCase(CarroGateway gateway) {
        return new AdicionarCarroInteractor(gateway);
    }

    @Bean
    AlterarCarroInteractor updateUseCase(CarroGateway gateway) {
        return new AlterarCarroInteractor(gateway);
    }

    @Bean
    RemoverCarroInteractor deleteUseCase(CarroGateway gateway) {
        return new RemoverCarroInteractor(gateway);
    }
}
