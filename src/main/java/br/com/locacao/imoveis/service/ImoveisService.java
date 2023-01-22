package br.com.locacao.imoveis.service;

import br.com.locacao.imoveis.DTO.ImoveisDTO;
import br.com.locacao.imoveis.model.Imoveis;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ImoveisService {

    List<Imoveis> buscarTodosImoveis();

    Imoveis criarImovel(ImoveisDTO imoveisDTO) throws IOException;

    Optional<Imoveis> buscarImovelPorId(Long id);

    Imoveis atualizarImovel(ImoveisDTO imoveisDTO) throws IOException;

    void deleteImovelPorId(Long id);

    List<Imoveis> buscarImoveisAtivos();

    List<Imoveis> buscarImoveisInativos();

    List<Imoveis> buscarImoveisLocados();

    List<Imoveis> buscarImoveisNaoLocados();


}
