package br.com.locacao.imoveis.controller;


import br.com.locacao.imoveis.model.Enderecos;
import br.com.locacao.imoveis.service.EnderecosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/enderecos")
@RequiredArgsConstructor
@Api(tags = "Endereços Controller")
public class EnderecosController {

    private final EnderecosService enderecosService;

    @GetMapping
    @ApiOperation("Buscar todos os endereços")
    public ResponseEntity<List<Enderecos>> buscarTodosEnderecos(){
        return ResponseEntity.ok(enderecosService.buscarTodosEnderecos());
    }

    @GetMapping("/{cep}")
    @ApiOperation("Buscar enderecos por cep")
    public ResponseEntity<Optional<Enderecos>> buscarEnderecoPorCep(@PathVariable String cep){
        return ResponseEntity.ok(enderecosService.buscarEnderecoPorCep(cep));
    }
}
