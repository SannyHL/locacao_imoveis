package br.com.locacao.imoveis.service;

import br.com.locacao.imoveis.model.Enderecos;

import java.util.List;
import java.util.Optional;

public interface EnderecosService {

    List<Enderecos> buscarTodosEnderecos();

    Optional<Enderecos> buscarEnderecoPorCep(String cep);
}
