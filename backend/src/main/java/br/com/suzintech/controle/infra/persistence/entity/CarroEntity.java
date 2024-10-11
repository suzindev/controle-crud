package br.com.suzintech.controle.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_carro")
public class CarroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca", referencedColumnName = "id", nullable = false)
    private MarcaEntity marca;

    @ManyToMany
    @JoinTable(
            name = "tb_carro_acessorio",
            joinColumns = @JoinColumn(name = "id_carro", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_acessorio", referencedColumnName = "id")
    )
    private List<AcessorioEntity> acessorios;
}
