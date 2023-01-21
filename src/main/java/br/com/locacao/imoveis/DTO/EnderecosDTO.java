package br.com.locacao.imoveis.DTO;

import jakarta.validation.constraints.NotBlank;

public class EnderecosDTO {

    @NotBlank
    private String cep;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String bairro;
    @NotBlank
    private String localidade;
    @NotBlank
    private String uf;
}
