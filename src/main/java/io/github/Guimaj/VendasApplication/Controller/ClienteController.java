package io.github.Guimaj.VendasApplication.Controller;

import io.github.Guimaj.VendasApplication.Model.Cliente;
import io.github.Guimaj.VendasApplication.Repository.ClienteRepository;
import io.github.Guimaj.VendasApplication.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid Cliente cliente){
        return clienteService.save(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes(){
        return clienteService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id){
        return clienteService.findById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        return clienteService.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @Valid @RequestBody Cliente cliente){
        return clienteService.update(id,cliente);
    }

}
