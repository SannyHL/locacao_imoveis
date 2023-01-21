package br.com.locacao.imoveis.DTO;

import br.com.locacao.imoveis.model.Enderecos;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDTO {


    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpfCnpj;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;

    @NotBlank
    private Long numeroCasa;

    @NotBlank
    private Enderecos endereco;
}
