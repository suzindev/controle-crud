package br.com.suzintech.controle.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, length = 8, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(length = 8, nullable = false)
    private String role;
}
