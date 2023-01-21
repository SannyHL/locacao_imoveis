package br.com.locacao.imoveis.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public class ClienteDTO {

    @NotBlank
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpfCnpj;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
}
