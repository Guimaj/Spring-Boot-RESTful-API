package io.github.Guimaj.VendasApplication.Service;

import io.github.Guimaj.VendasApplication.Model.Cliente;
import io.github.Guimaj.VendasApplication.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<Cliente> save(Cliente cliente){
        return new ResponseEntity<Cliente>(clienteRepository.save(cliente),HttpStatus.CREATED);
    }

    public ResponseEntity<Cliente> findById(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        return new ResponseEntity<>(clientes,HttpStatus.OK);
    }

    public  ResponseEntity<?> deleteById(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            clienteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<?> update(Integer id, Cliente cliente){
        Optional<Cliente> c = clienteRepository.findById(id);

        if(c.isPresent()){
            clienteRepository.save(cliente);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }


}
