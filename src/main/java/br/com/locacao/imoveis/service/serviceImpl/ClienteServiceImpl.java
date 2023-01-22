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


    @Override
    public Clientes criarCliente(ClientesDTO clientes) throws IOException {
        String cep = MethodsUtils.buscaCep(clientes.getEndereco().getCep());
        Enderecos endereco = new Gson().fromJson(cep, Enderecos.class);
        Optional<Enderecos> verificaEndereco = enderecosRepository.findById(endereco.getCep());

        if (verificaEndereco.isEmpty()){
            enderecosRepository.saveAndFlush(endereco);
        }
        clientes.setEndereco(endereco);
        return clienteRepository.save(modelMapper.map(clientes, Clientes.class));

    }

    @Override
    public Optional<Clientes> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Clientes atualizarCliente(ClientesDTO clientes) throws IOException {
        String cep = MethodsUtils.buscaCep(clientes.getEndereco().getCep());
        Enderecos endereco = new Gson().fromJson(cep, Enderecos.class);
        Optional<Enderecos> verificaEndereco = enderecosRepository.findById(endereco.getCep());

        if (verificaEndereco.isEmpty()){
            enderecosRepository.saveAndFlush(endereco);
        }
        clientes.setEndereco(endereco);
        return clienteRepository.save(modelMapper.map(clientes, Clientes.class));
    }

    @Override
    public void deleteClientePorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
