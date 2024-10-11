package br.com.suzintech.controle.domain;

public record Acessorio(Long id, String nome) {

    public Acessorio(String nome) {
        this(null, nome);
    }
}
