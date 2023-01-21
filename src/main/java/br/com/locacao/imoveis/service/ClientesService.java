package br.com.locacao.imoveis.service;

import br.com.locacao.imoveis.model.Cliente;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ClientesService {

    List<Cliente> todosCliente();
    Cliente criarCliente(Cliente cliente) throws IOException;

    Optional<Cliente> buscarCliente(Cliente cliente);


    Cliente atualizarCliente(Cliente cliente);

    String deleteCliente(Cliente cliente);
}
