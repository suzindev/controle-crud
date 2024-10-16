package br.com.suzintech.controle.domain;

public record Usuario(
        Long id,
        String username,
        String password,
        String role
) {
    public Usuario(String username, String password, String role) {
        this(null, username, password, role);
    }
}
