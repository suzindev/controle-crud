package br.com.suzintech.controle.domain;

public record Carro(Long id, String nome, Integer ano) {

    public Carro(String nome, Integer ano) {
        this(null, nome, ano);
    }
}
