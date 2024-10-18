package br.com.suzintech.controle.application.gateway;

import br.com.suzintech.controle.domain.Carro;

import java.util.List;

public interface CarroGateway {

    String create(Carro carro);

    String update(Carro carro, Long id);

    String delete(Long id);

    List<Carro> findAll();

    Carro findById(Long id);
}
