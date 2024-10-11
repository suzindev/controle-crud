package br.com.suzintech.controle.application.gateway;

import br.com.suzintech.controle.domain.Acessorio;

import java.util.List;

public interface AcessorioGateway {

    String create(Acessorio request);

    String update(Acessorio request, Long id);

    String delete(Long id);

    List<Acessorio> findAll();

    Acessorio findById(Long id);
}
