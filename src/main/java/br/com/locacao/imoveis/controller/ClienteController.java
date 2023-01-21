package br.com.locacao.imoveis.controller;


import br.com.locacao.imoveis.DTO.ClientesDTO;
import br.com.locacao.imoveis.model.Clientes;
import br.com.locacao.imoveis.service.ClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/cliente")
@RequiredArgsConstructor
public class ClienteController {

   private final ClientesService clienteService;
    @PostMapping
    public ResponseEntity<ClientesDTO> criarCliente(@RequestBody ClientesDTO clientesDTO) throws IOException {
        Clientes clientes = clienteService.criarCliente(clientesDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(clientes.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @GetMapping
    public ResponseEntity<Optional<Clientes>> buscarCliente(@RequestBody Clientes clientes){
        return ResponseEntity.ok(clienteService.buscarCliente(clientes));
    }
    @PutMapping
    public ResponseEntity<Clientes> atualizarCliente(@RequestBody Clientes clientes){
        return ResponseEntity.ok(clienteService.atualizarCliente(clientes));
    }
    @DeleteMapping
    public ResponseEntity<String> deleteCliente(@RequestBody Clientes clientes){
        return ResponseEntity.ok(clienteService.deleteCliente(clientes));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Clientes>> allCliente(){
        return ResponseEntity.ok(clienteService.buscarTodosCliente());
    }
}
