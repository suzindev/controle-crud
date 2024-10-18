package br.com.suzintech.controle.application.gateway;

import br.com.suzintech.controle.domain.Acessorio;

import java.util.List;

public interface AcessorioGateway {

    String create(Acessorio acessorio);

    String update(Acessorio acessorio, Long id);

    String delete(Long id);

    List<Acessorio> findAll();

    Acessorio findById(Long id);

    List<Acessorio> findByIds(List<Long> ids);
}
