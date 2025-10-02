package com.cti.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private Integer idade;
    private String raca;

    @Column(name = "nome_tutor")
    private String nomeTutor;

    @Column(name = "petisco_favorito")
    private String petiscoFavorito;
}
