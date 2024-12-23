package br.com.suzintech.controle.infra.controller;

import br.com.suzintech.controle.infra.adapter.CarroAdapter;
import br.com.suzintech.controle.application.usecase.carro.*;
import br.com.suzintech.controle.domain.Carro;
import br.com.suzintech.controle.infra.controller.request.CarroRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
@RequiredArgsConstructor
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
public class CarroController {

    private final AdicionarCarroInteractor adicionarCarroInteractor;
    private final AlterarCarroInteractor alterarCarroInteractor;
    private final RemoverCarroInteractor removerCarroInteractor;
    private final ConsultarTodosCarroInteractor consultarTodosCarroInteractor;
    private final ConsultarCarroPorIdInteractor consultarCarroPorIdInteractor;

    private final CarroAdapter carroAdapter;

    @PostMapping
    ResponseEntity<String> create(@Valid @RequestBody CarroRequest request) {
        var obj = adicionarCarroInteractor.execute(carroAdapter.from(request));

        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> update(@Valid @RequestBody CarroRequest request, @PathVariable Long id) {
        var obj = alterarCarroInteractor.execute(carroAdapter.from(request), id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        var obj = removerCarroInteractor.execute(id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<Carro>> getAll() {
        var obj = consultarTodosCarroInteractor.execute();

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Carro> getById(@PathVariable Long id) {
        var obj = consultarCarroPorIdInteractor.execute(id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
