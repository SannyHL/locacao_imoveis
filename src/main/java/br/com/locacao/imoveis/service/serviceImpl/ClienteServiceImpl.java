package br.com.locacao.imoveis.service.serviceImpl;

import br.com.locacao.imoveis.model.Cliente;
import br.com.locacao.imoveis.repository.ClientesRepository;
import br.com.locacao.imoveis.service.ClientesService;
import br.com.locacao.imoveis.utils.MethodsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClientesService {

    private final ClientesRepository clienteRepository;

    @Override
    public List<Cliente> todosCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente criarCliente(Cliente cliente) throws IOException {
        //validar ou colocar notações ....
        //validar se cpf ja existe?? ou email ??
        String x = MethodsUtils.buscaCep("31270110");
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarCliente(Cliente cliente) {
        return clienteRepository.findById(cliente.getId());
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        clienteRepository.findById(cliente.getId()).ifPresent(
                item -> {
                    item.setNome(cliente.getNome());
                    item.setCpfCnpj(cliente.getCpfCnpj());
                    item.setTelefone(cliente.getTelefone());
                    item.setEmail(cliente.getEmail());
                }
        );
        return cliente;
    }

    @Override
    public String deleteCliente(Cliente cliente) {
        try{
            clienteRepository.delete(cliente);
            return cliente.getNome() + " Detelado com sucesso.";
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
