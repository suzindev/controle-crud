package br.com.suzintech.controle.infra.controller;

import br.com.suzintech.controle.application.usecase.marca.*;
import br.com.suzintech.controle.domain.Marca;
import br.com.suzintech.controle.infra.controller.request.MarcaRequest;
import br.com.suzintech.controle.infra.mapper.MarcaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MarcaController {

    private final AdicionarMarcaInteractor adicionarMarcaInteractor;
    private final AlterarMarcaInteractor alterarMarcaInteractor;
    private final RemoverMarcaInteractor removerMarcaInteractor;
    private final ConsultarTodosMarcaInteractor consultarTodosMarcaInteractor;
    private final ConsultarMarcaPorIdInteractor consultarMarcaPorIdInteractor;

    private final MarcaMapper marcaMapper;

    @PostMapping
    ResponseEntity<String> create(@Valid @RequestBody MarcaRequest request) {
        var obj = adicionarMarcaInteractor.execute(marcaMapper.toDTO(request));

        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> update(@Valid @RequestBody MarcaRequest request, @PathVariable Long id) {
        var obj = alterarMarcaInteractor.execute(marcaMapper.toDTO(request), id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        var obj = removerMarcaInteractor.execute(id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<Marca>> getAll() {
        var obj = consultarTodosMarcaInteractor.execute();

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Marca> getById(@PathVariable Long id) {
        var obj = consultarMarcaPorIdInteractor.execute(id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
