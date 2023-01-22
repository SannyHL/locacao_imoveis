package br.com.locacao.imoveis.service.serviceImpl;


import br.com.locacao.imoveis.model.Enderecos;
import br.com.locacao.imoveis.repository.EnderecosRepository;
import br.com.locacao.imoveis.service.EnderecosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnderecosServiceImpl implements EnderecosService {

    private final EnderecosRepository enderecosRepository;

    @Override
    public List<Enderecos> buscarTodosEnderecos() {
        return enderecosRepository.findAll();
    }

    @Override
    public Optional<Enderecos> buscarEnderecoPorCep(String cep) {
        return enderecosRepository.findById(cep);
    }
}
