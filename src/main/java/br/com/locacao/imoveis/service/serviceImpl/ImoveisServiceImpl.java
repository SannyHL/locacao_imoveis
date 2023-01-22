package br.com.locacao.imoveis.service.serviceImpl;


import br.com.locacao.imoveis.DTO.ImoveisDTO;
import br.com.locacao.imoveis.model.Enderecos;
import br.com.locacao.imoveis.model.Imoveis;
import br.com.locacao.imoveis.repository.EnderecosRepository;
import br.com.locacao.imoveis.repository.ImoveisRepository;
import br.com.locacao.imoveis.service.ImoveisService;
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
public class ImoveisServiceImpl implements ImoveisService {

    private final EnderecosRepository enderecosRepository;
    private final ModelMapper modelMapper;
    private final ImoveisRepository imoveisRepository;

    @Override
    public List<Imoveis> buscarTodosImoveis() {
        return imoveisRepository.findAll();
    }

    @Override
    public Imoveis criarImovel(ImoveisDTO imoveisDTO) throws IOException {
        String cep = MethodsUtils.buscaCep(imoveisDTO.getEndereco().getCep());
        Enderecos endereco = new Gson().fromJson(cep, Enderecos.class);
        Optional<Enderecos> verificaEndereco = enderecosRepository.findById(endereco.getCep());

        if (verificaEndereco.isEmpty()){
            enderecosRepository.saveAndFlush(endereco);
        }
        imoveisDTO.setEndereco(endereco);
        return imoveisRepository.save(modelMapper.map(imoveisDTO, Imoveis.class));

    }

    @Override
    public Optional<Imoveis> buscarImovelPorId(Long id) {
        return imoveisRepository.findById(id);
    }

    @Override
    public Imoveis atualizarImovel(ImoveisDTO imoveisDTO) throws IOException {
        String cep = MethodsUtils.buscaCep(imoveisDTO.getEndereco().getCep());
        Enderecos endereco = new Gson().fromJson(cep, Enderecos.class);
        Optional<Enderecos> verificaEndereco = enderecosRepository.findById(endereco.getCep());

        if (verificaEndereco.isEmpty()){
            enderecosRepository.saveAndFlush(endereco);
        }
        imoveisDTO.setEndereco(endereco);
        return imoveisRepository.save(modelMapper.map(imoveisDTO, Imoveis.class));

    }

    @Override
    public void deleteImovelPorId(Long id) {
        imoveisRepository.deletarImovel(id);
    }

    @Override
    public List<Imoveis> buscarImoveisAtivos() {
        return imoveisRepository.buscarImoveisAtivos();

    }

    @Override
    public List<Imoveis> buscarImoveisInativos() {
        return imoveisRepository.buscarImoveisInativos();

    }

    @Override
    public List<Imoveis> buscarImoveisLocados() {
        return imoveisRepository.buscarImoveisLocados();

    }

    @Override
    public List<Imoveis> buscarImoveisNaoLocados() {
        return imoveisRepository.buscarImoveisNaoLocados();

    }
}
