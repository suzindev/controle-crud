package br.com.suzintech.controle.application.gateway;

import br.com.suzintech.controle.domain.Marca;

import java.util.List;

public interface MarcaGateway {

    String create(Marca marca);

    String update(Marca marca, Long id);

    String delete(Long id);

    List<Marca> findAll();

    Marca findById(Long id);
}
