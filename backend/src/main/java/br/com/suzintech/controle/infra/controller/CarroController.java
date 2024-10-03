package br.com.suzintech.controle.infra.controller;

import br.com.suzintech.controle.application.usecase.AdicionarCarroInteractor;
import br.com.suzintech.controle.application.usecase.AlterarCarroInteractor;
import br.com.suzintech.controle.application.usecase.RemoverCarroInteractor;
import br.com.suzintech.controle.infra.controller.request.CarroRequest;
import br.com.suzintech.controle.infra.mapper.CarroMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carro")
@RequiredArgsConstructor
public class CarroController {

    private final AdicionarCarroInteractor adicionarCarroInteractor;
    private final AlterarCarroInteractor alterarCarroInteractor;
    private final RemoverCarroInteractor removerCarroInteractor;

    private final CarroMapper mapper;

    @PostMapping
    ResponseEntity<String> create(@RequestBody CarroRequest request) {
        var obj = adicionarCarroInteractor.execute(mapper.toDTO(request));

        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> update(@RequestBody CarroRequest request, @PathVariable Long id) {
        var obj = alterarCarroInteractor.execute(mapper.toDTO(request), id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        var obj = removerCarroInteractor.execute(id);

        return new ResponseEntity<>(obj, HttpStatus.NO_CONTENT);
    }
}
