package io.github.Guimaj.VendasApplication.Repository;

import io.github.Guimaj.VendasApplication.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
