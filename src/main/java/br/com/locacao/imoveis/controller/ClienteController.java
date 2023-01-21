package br.com.locacao.imoveis.controller;


import br.com.locacao.imoveis.DTO.ClientesDTO;
import br.com.locacao.imoveis.model.Clientes;
import br.com.locacao.imoveis.service.ClientesService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Clientes>> allCliente(){
        return ResponseEntity.ok(clienteService.buscarTodosCliente());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Clientes>> buscarClientePorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarClientePorId(id));
    }

    @PostMapping
    public ResponseEntity<ClientesDTO> criarCliente(@RequestBody ClientesDTO clientesDTO) throws IOException {
        Clientes clientes = clienteService.criarCliente(clientesDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(clientes.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/atualizar-cliente/{id}")
    public ResponseEntity<ClientesDTO> atualizarCliente(@RequestBody ClientesDTO clientes, @PathVariable Long id) throws IOException {
        clientes.setId(id);
        return ResponseEntity.ok().body(modelMapper.map(clienteService.atualizarCliente(clientes), ClientesDTO.class));
    }
    @DeleteMapping("/deletar-cliente/{id}")
    public ResponseEntity<ClientesDTO> deleteClientePorId(@PathVariable Long id){
        clienteService.deleteClientePorId(id);
        return ResponseEntity.noContent().build();
    }


}
