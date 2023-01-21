package br.com.locacao.imoveis.DTO;

import br.com.locacao.imoveis.model.Cliente;
import br.com.locacao.imoveis.model.Imoveis;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContratosDTO {

    @NotBlank
    private Long id;
    @NotBlank
    private Long valorLocacao;
    private Date dataInicio;
    @NotBlank
    private Date dataFim;
    @NotBlank
    private Cliente cliente;
    @NotBlank
    private Imoveis imovel;
}
