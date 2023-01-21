package br.com.locacao.imoveis.service.serviceImpl;

import br.com.locacao.imoveis.DTO.ClientesDTO;
import br.com.locacao.imoveis.model.Clientes;
import br.com.locacao.imoveis.model.Enderecos;
import br.com.locacao.imoveis.repository.ClientesRepository;
import br.com.locacao.imoveis.repository.EnderecosRepository;
import br.com.locacao.imoveis.service.ClientesService;
import br.com.locacao.imoveis.utils.MethodsUtils;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClientesService {

    private final ClientesRepository clienteRepository;
    private final EnderecosRepository enderecosRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<Clientes> buscarTodosCliente() {
        return clienteRepository.findAll();
    }

    public Clientes buscarClientesPorId(Long id){
         Optional<Clientes> clientes = clienteRepository.findById(id);

         return clientes.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @Override
    public Clientes criarCliente(ClientesDTO clientes) throws IOException {
        String cep = MethodsUtils.buscaCep(clientes.getEndereco().getCep());
        Enderecos endereco = new Gson().fromJson(cep, Enderecos.class);
        Optional<Enderecos> verificaEndereco = enderecosRepository.findById(endereco.getCep());

        Clientes salvarCliente = clienteRepository.save(modelMapper.map(clientes, Clientes.class));
        if (verificaEndereco.isEmpty()){
            enderecosRepository.saveAndFlush(endereco);
        }
        return salvarCliente;

    }

    @Override
    public Optional<Clientes> buscarCliente(Clientes clientes) {
        return clienteRepository.findById(clientes.getId());
    }

    @Override
    public Clientes atualizarCliente(Clientes clientes) {
        clienteRepository.findById(clientes.getId()).ifPresent(
                item -> {
                    item.setNome(clientes.getNome());
                    item.setCpfCnpj(clientes.getCpfCnpj());
                    item.setTelefone(clientes.getTelefone());
                    item.setEmail(clientes.getEmail());
                }
        );
        return clientes;
    }

    @Override
    public String deleteCliente(Clientes clientes) {
        try{
            clienteRepository.delete(clientes);
            return clientes.getNome() + " Detelado com sucesso.";
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
