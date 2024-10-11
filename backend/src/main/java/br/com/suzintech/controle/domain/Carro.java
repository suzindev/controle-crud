package br.com.suzintech.controle.domain;

import java.util.List;

public record Carro(Long id, String nome, Integer ano, Marca marca, List<Acessorio> acessorios) {

    public Carro(String nome, Integer ano, Marca marca, List<Acessorio> acessorios) {
        this(null, nome, ano, marca, acessorios);
    }
}
