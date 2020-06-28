package io.github.Guimaj.VendasApplication.Model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    @NotEmpty(message = "{nome.obrigatorio}")
    private String nome;

    @Column(nullable = false, length = 11)
    @CPF(message = "{cpf.valido}")
    @NotNull(message = "{cpf.obrigatorio}")
    private String cpf;
}
