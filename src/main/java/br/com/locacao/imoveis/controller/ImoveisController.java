package br.com.locacao.imoveis.controller;

import br.com.locacao.imoveis.DTO.ImoveisDTO;
import br.com.locacao.imoveis.model.Imoveis;
import br.com.locacao.imoveis.service.ImoveisService;
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
@RequestMapping("/api/v1/imoveis")
@RequiredArgsConstructor
@Api(value = "Imoveis Controller")
public class ImoveisController {

    private final ImoveisService imoveisService;
    private final ModelMapper modelMapper;


    @GetMapping
    @ApiOperation(value = "Buscar todos os imoveis")
    public ResponseEntity<List<Imoveis>> buscarTodosImoveis(){
        return ResponseEntity.ok(imoveisService.buscarTodosImoveis());
    }

    @GetMapping("/buscar-imoveis-ativos")
    @ApiOperation( value = "Buscar todos os imoveis ativos")
    public ResponseEntity<List<Imoveis>> buscarImoveisAtivos(){
        return ResponseEntity.ok(imoveisService.buscarImoveisAtivos());
    }

    @GetMapping("/buscar-imoveis-inativos")
    @ApiOperation(value = "Buscar todos os imoveis inativos")
    public ResponseEntity<List<Imoveis>> buscarImoveisInativos(){
        return ResponseEntity.ok(imoveisService.buscarImoveisInativos());
    }

    @GetMapping("/buscar-imoveis-locados")
    @ApiOperation(value = "Buscar todos os imoveis locados")
    public ResponseEntity<List<Imoveis>> buscarImoveisLocados(){
        return ResponseEntity.ok(imoveisService.buscarImoveisLocados());
    }

    @GetMapping("/buscar-imoveis-nao-locados")
    @ApiOperation(value = "Buscar todos os imoveis não locados")
    public ResponseEntity<List<Imoveis>> buscarImoveisNaoLocados(){
        return ResponseEntity.ok(imoveisService.buscarImoveisNaoLocados());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar imovel por id")
    public ResponseEntity<Optional<Imoveis>> buscarImovelPorId(@PathVariable Long id){
        return ResponseEntity.ok(imoveisService.buscarImovelPorId(id));
    }

    @PostMapping
    @ApiOperation(value = "Adicionar novo imóvel")
    public ResponseEntity<ImoveisDTO> criarCliente(@RequestBody ImoveisDTO imoveisDTO) throws IOException {
        Imoveis imoveis = imoveisService.criarImovel(imoveisDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(imoveis.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/atualizar-imovel/{id}")
    @ApiOperation(value = "Atualizar imóvel por id")
    public ResponseEntity<ImoveisDTO> atualizarCliente(@RequestBody ImoveisDTO imoveisDTO, @PathVariable Long id) throws IOException {
        imoveisDTO.setId(id);
        return ResponseEntity.ok().body(modelMapper.map(imoveisService.atualizarImovel(imoveisDTO), ImoveisDTO.class));
    }

    @DeleteMapping("/deletar-imovel/{id}")
    @ApiOperation(value = "Deletar imóvel por id")
    public ResponseEntity<ImoveisDTO> deleteImovelPorId(@PathVariable Long id){
        imoveisService.deleteImovelPorId(id);
        return ResponseEntity.noContent().build();
    }
}
