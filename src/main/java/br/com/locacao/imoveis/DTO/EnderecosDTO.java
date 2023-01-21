package br.com.locacao.imoveis.DTO;

import jakarta.validation.constraints.NotBlank;

public class EnderecosDTO {

    @NotBlank
    private Long id;
    @NotBlank
    private String cep;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String complemento;
    @NotBlank
    private String bairro;
    @NotBlank
    private String localidade;
    @NotBlank
    private String uf;
    @NotBlank
    private String ibge;
    @NotBlank
    private String gia;
    @NotBlank
    private String ddd;
    @NotBlank
    private String siafi;
}
