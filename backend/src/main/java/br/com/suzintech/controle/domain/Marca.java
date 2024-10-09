package br.com.suzintech.controle.domain;

public record Marca(Long id, String nome) {

    public Marca(String nome) {
        this(null, nome);
    }
}
