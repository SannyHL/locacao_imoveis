package br.com.locacao.imoveis.controller;


import br.com.locacao.imoveis.DTO.ClientesDTO;
import br.com.locacao.imoveis.model.Clientes;
import br.com.locacao.imoveis.service.ClientesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "Clientes Controller")
public class ClientesController {

    private final ClientesService clienteService;
    private final ModelMapper modelMapper;

    @GetMapping
    @ApiOperation("Buscar todos os Clientes")
    public ResponseEntity<List<Clientes>> buscarTodosCliente(){
        return ResponseEntity.ok(clienteService.buscarTodosCliente());
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar clientes por id")
    public ResponseEntity<Optional<Clientes>> buscarClientePorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarClientePorId(id));
    }

    @PostMapping
    @ApiOperation("Criar novos clientes")
    public ResponseEntity<ClientesDTO> criarCliente(@RequestBody ClientesDTO clientesDTO) throws IOException {
        Clientes clientes = clienteService.criarCliente(clientesDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(clientes.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/atualizar-cliente/{id}")
    @ApiOperation("Atualizar clientes por id")
    public ResponseEntity<ClientesDTO> atualizarCliente(@RequestBody ClientesDTO clientes, @PathVariable Long id) throws IOException {
        clientes.setId(id);
        return ResponseEntity.ok().body(modelMapper.map(clienteService.atualizarCliente(clientes), ClientesDTO.class));
    }
    @DeleteMapping("/deletar-cliente/{id}")
    @ApiOperation("Deletar clientes por id")
    public ResponseEntity<ClientesDTO> deleteClientePorId(@PathVariable Long id){
        clienteService.deleteClientePorId(id);
        return ResponseEntity.noContent().build();
    }


}
