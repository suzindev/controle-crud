package br.com.suzintech.controle.infra.adapter;

import br.com.suzintech.controle.application.usecase.acessorio.ConsultarAcessorioPorIdsInteractor;
import br.com.suzintech.controle.application.usecase.marca.ConsultarMarcaPorIdInteractor;
import br.com.suzintech.controle.commom.Adapter;
import br.com.suzintech.controle.domain.Carro;
import br.com.suzintech.controle.infra.controller.request.CarroRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarroAdapter implements Adapter<CarroRequest, Carro> {

    private final ConsultarMarcaPorIdInteractor consultarMarcaPorIdInteractor;

    private final ConsultarAcessorioPorIdsInteractor consultarAcessorioPorIdsInteractor;

    @Override
    public Carro from(CarroRequest obj) {
        var marca = consultarMarcaPorIdInteractor.execute(obj.idMarca());
        var listaAcessorios = consultarAcessorioPorIdsInteractor.execute(obj.idsAcessorios());

        return new Carro(
                obj.nome(),
                obj.ano(),
                marca,
                listaAcessorios
        );
    }
}
