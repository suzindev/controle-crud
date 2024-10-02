package br.com.suzintech.controle.infra.controller;

import br.com.suzintech.controle.application.usecase.AdicionarCarroInteractor;
import br.com.suzintech.controle.infra.controller.request.CarroRequest;
import br.com.suzintech.controle.infra.controller.response.CarroResponse;
import br.com.suzintech.controle.infra.mapper.CarroMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
@RequiredArgsConstructor
public class CarroController {

    private final AdicionarCarroInteractor adicionarCarroInteractor;
    private final CarroMapper mapper;

    @PostMapping
    ResponseEntity<CarroResponse> create(@RequestBody CarroRequest request) {
        var obj = adicionarCarroInteractor.execute(mapper.toDTO(request));

        return new ResponseEntity<>(mapper.toResponse(obj), HttpStatus.CREATED);
    }
}
