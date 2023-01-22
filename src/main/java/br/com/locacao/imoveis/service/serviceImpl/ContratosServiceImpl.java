package br.com.locacao.imoveis.service.serviceImpl;


import br.com.locacao.imoveis.DTO.ContratosDTO;
import br.com.locacao.imoveis.model.Contratos;
import br.com.locacao.imoveis.repository.ContratosRepository;
import br.com.locacao.imoveis.service.ContratosService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContratosServiceImpl implements ContratosService {

    private final ContratosRepository contratosRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Contratos> buscarTodosContratos() {
        return contratosRepository.findAll();
    }

    @Override
    public Contratos criarContrato(ContratosDTO contratosDTO){
        return contratosRepository.save(modelMapper.map(contratosDTO, Contratos.class));
    }

    @Override
    public Optional<Contratos> buscarContratoPorId(Long id) {
        return contratosRepository.findById(id);
    }

    @Override
    public Contratos atualizarContrato(ContratosDTO contratosDTO){
        return contratosRepository.save(modelMapper.map(contratosDTO, Contratos.class));
    }

    @Override
    public void deleteContratoPorId(Long id) {
        contratosRepository.deleteContratoPorId(id);
    }
}
