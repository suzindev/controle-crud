package br.com.suzintech.controle.main;

import br.com.suzintech.controle.application.gateway.CarroGateway;
import br.com.suzintech.controle.application.usecase.carro.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarroConfig {

    @Bean
    AdicionarCarroInteractor createCarroUseCase(CarroGateway gateway) {
        return new AdicionarCarroInteractor(gateway);
    }

    @Bean
    AlterarCarroInteractor updateCarroUseCase(CarroGateway gateway) {
        return new AlterarCarroInteractor(gateway);
    }

    @Bean
    RemoverCarroInteractor deleteCarroUseCase(CarroGateway gateway) {
        return new RemoverCarroInteractor(gateway);
    }

    @Bean
    ConsultarTodosCarroInteractor getAllCarroUseCase(CarroGateway gateway) {
        return new ConsultarTodosCarroInteractor(gateway);
    }

    @Bean
    ConsultarCarroPorIdInteractor getByIdCarroUseCase(CarroGateway gateway) {
        return new ConsultarCarroPorIdInteractor(gateway);
    }
}
