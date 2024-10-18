package br.com.suzintech.controle.infra.controller;

import br.com.suzintech.controle.application.usecase.acessorio.*;
import br.com.suzintech.controle.domain.Acessorio;
import br.com.suzintech.controle.infra.controller.request.AcessorioRequest;
import br.com.suzintech.controle.infra.mapper.AcessorioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acessorio")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AcessorioController {

    private final AdicionarAcessorioInteractor adicionarAcessorioInteractor;
    private final AlterarAcessorioInteractor alterarAcessorioInteractor;
    private final RemoverAcessorioInteractor removerAcessorioInteractor;
    private final ConsultarTodosAcessorioInteractor consultarTodosAcessorioInteractor;
    private final ConsultarAcessorioPorIdInteractor consultarAcessorioPorIdInteractor;

    private final AcessorioMapper acessorioMapper;

    @PostMapping
    ResponseEntity<String> create(@Valid @RequestBody AcessorioRequest request) {
        var obj = adicionarAcessorioInteractor.execute(acessorioMapper.toDTO(request));

        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> update(@Valid @RequestBody AcessorioRequest request, @PathVariable Long id) {
        var obj = alterarAcessorioInteractor.execute(acessorioMapper.toDTO(request), id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        var obj = removerAcessorioInteractor.execute(id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<Acessorio>> getAll() {
        var obj = consultarTodosAcessorioInteractor.execute();

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Acessorio> getById(@PathVariable Long id) {
        var obj = consultarAcessorioPorIdInteractor.execute(id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
