package br.com.locacao.imoveis.service;

import br.com.locacao.imoveis.DTO.ClientesDTO;
import br.com.locacao.imoveis.model.Clientes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ClientesService {

    List<Clientes> buscarTodosCliente();

    Clientes criarCliente(ClientesDTO clientes) throws IOException;

    Optional<Clientes> buscarCliente(Clientes clientes);

    Clientes atualizarCliente(Clientes clientes);

    String deleteCliente(Clientes clientes);
}
