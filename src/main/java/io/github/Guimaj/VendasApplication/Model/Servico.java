package io.github.Guimaj.VendasApplication.Model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}
