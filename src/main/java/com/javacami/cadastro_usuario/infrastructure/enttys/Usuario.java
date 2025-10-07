package com.javacami.cadastro_usuario.infrastructure.enttys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name= "email", unique = true)
    private String email;

    @Column(name= "nome")
    private String nome;
}
