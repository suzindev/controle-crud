package br.com.suzintech.controle.domain;

public record Carro(Long id, String nome, Integer ano, Marca marca) {

    public Carro(String nome, Integer ano, Marca marca) {
        this(null, nome, ano, marca);
    }
}
