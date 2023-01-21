package br.com.locacao.imoveis.service;

import br.com.locacao.imoveis.DTO.ContratosDTO;
import br.com.locacao.imoveis.model.Contratos;

import java.util.List;
import java.util.Optional;

public interface ContratosService {

    List<Contratos> buscarTodosContratos();

    Contratos criarContrato(ContratosDTO contratosDTO);

    Optional<Contratos> buscarContratoPorId(Long id);

    Contratos atualizarContrato(ContratosDTO contratosDTO);

    void deleteContratoPorId(Long id);
}
