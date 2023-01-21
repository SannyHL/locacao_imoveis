package br.com.locacao.imoveis.service;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperService {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
