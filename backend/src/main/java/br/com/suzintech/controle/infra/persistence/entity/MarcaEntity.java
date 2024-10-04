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
@Table(name = "tb_marca")
public class MarcaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "marca")
    private List<CarroEntity> carros;
}
