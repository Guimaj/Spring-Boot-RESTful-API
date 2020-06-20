package io.github.Guimaj.VendasApplication.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 3)
    private Integer idade;

    @Column(nullable = false, length = 11)
    private String cpf;
}
