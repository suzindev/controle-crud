package br.com.suzintech.controle.infra.controller;

import br.com.suzintech.controle.application.usecase.usuario.*;
import br.com.suzintech.controle.domain.Usuario;
import br.com.suzintech.controle.infra.controller.request.UsuarioRequest;
import br.com.suzintech.controle.infra.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
public class UsuarioController {

    private final AdicionarUsuarioInteractor adicionarUsuarioInteractor;
    private final AlterarUsuarioInteractor alterarUsuarioInteractor;
    private final RemoverUsuarioInteractor removerUsuarioInteractor;
    private final ConsultarTodosUsuarioInteractor consultarTodosUsuarioInteractor;
    private final ConsultarUsuarioPorIdInteractor consultarUsuarioPorIdInteractor;

    private final UsuarioMapper usuarioMapper;

    @PostMapping
    ResponseEntity<String> create(@Valid @RequestBody UsuarioRequest request) {
        var obj = adicionarUsuarioInteractor.execute(usuarioMapper.toDTO(request));

        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> update(@Valid @RequestBody UsuarioRequest request, @PathVariable Long id) {
        var obj = alterarUsuarioInteractor.execute(usuarioMapper.toDTO(request), id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        var obj = removerUsuarioInteractor.execute(id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<Usuario>> getAll() {
        var obj = consultarTodosUsuarioInteractor.execute();

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Usuario> getById(@PathVariable Long id) {
        var obj = consultarUsuarioPorIdInteractor.execute(id);

        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
