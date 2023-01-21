package br.com.locacao.imoveis.controller;

import br.com.locacao.imoveis.DTO.ClientesDTO;
import br.com.locacao.imoveis.DTO.ContratosDTO;
import br.com.locacao.imoveis.model.Contratos;
import br.com.locacao.imoveis.service.ContratosService;
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
@RequestMapping("/api/v1/contratos")
@RequiredArgsConstructor
public class ContratosController {

    private final ContratosService contratosService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Contratos>> buscarTodosContratos(){
        return ResponseEntity.ok(contratosService.buscarTodosContratos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contratos>> buscarContratoPorId(@PathVariable Long id){
        return ResponseEntity.ok(contratosService.buscarContratoPorId(id));
    }

    @PostMapping
    public ResponseEntity<ContratosDTO> criarContrato(@RequestBody ContratosDTO contratosDTO) throws IOException {
        Contratos contratos = contratosService.criarContrato(contratosDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(contratos.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/atualizar-contrato/{id}")
    public ResponseEntity<ContratosDTO> atualizarContrato(@RequestBody ContratosDTO contratosDTO, @PathVariable Long id){
        contratosDTO.setId(id);
        return ResponseEntity.ok().body(modelMapper.map(contratosService.atualizarContrato(contratosDTO), ContratosDTO.class));
    }
    @DeleteMapping("/deletar-cliente/{id}")
    public ResponseEntity<ClientesDTO> deleteClientePorId(@PathVariable Long id){
        contratosService.deleteContratoPorId(id);
        return ResponseEntity.noContent().build();
    }

}
