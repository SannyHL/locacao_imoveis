package br.com.locacao.imoveis.controller;


import br.com.locacao.imoveis.model.Cliente;
import br.com.locacao.imoveis.service.ClienteService;
import br.com.locacao.imoveis.utils.MethodsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/cliente")
@RequiredArgsConstructor
public class ClienteController {

   private final ClienteService clienteService;
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) throws IOException {
        return ResponseEntity.ok(clienteService.criarCliente(cliente));
    }
    @GetMapping
    public ResponseEntity<Optional<Cliente>> buscarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.buscarCliente(cliente));
    }
    @PutMapping
    public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.atualizarCliente(cliente));
    }
    @DeleteMapping
    public ResponseEntity<String> deleteCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.deleteCliente(cliente));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> allCliente(){
        return ResponseEntity.ok(clienteService.todosCliente());
    }
}
