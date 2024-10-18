package br.com.suzintech.controle.infra.controller;

import br.com.suzintech.controle.domain.Login;
import br.com.suzintech.controle.infra.config.AuthenticationService;
import br.com.suzintech.controle.infra.config.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginController {

    private final AuthenticationManager authenticationManager;

    private final AuthenticationService authenticationService;

    @PostMapping
    ResponseEntity<String> login(@RequestBody Login request) {
        var userAuthenticationToken = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        var auth = authenticationManager.authenticate(userAuthenticationToken);
        var token = authenticationService.gerarToken((CustomUserDetails) auth.getPrincipal());

        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
