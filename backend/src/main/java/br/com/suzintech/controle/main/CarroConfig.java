package br.com.suzintech.controle.main;

import br.com.suzintech.controle.application.gateway.CarroGateway;
import br.com.suzintech.controle.application.usecase.AdicionarCarroInteractor;
import br.com.suzintech.controle.infra.mapper.CarroMapper;
import br.com.suzintech.controle.infra.persistence.repository.CarroRepository;
import br.com.suzintech.controle.infra.service.CarroService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarroConfig {

    @Bean
    AdicionarCarroInteractor createUseCase(CarroGateway gateway) {
        return new AdicionarCarroInteractor(gateway);
    }

    @Bean
    CarroGateway gateway(CarroRepository repository, CarroMapper mapper) {
        return new CarroService(repository, mapper);
    }

    @Bean
    CarroMapper mapper() {
        return new CarroMapper();
    }
}
