package br.com.locacao.imoveis.DTO;

import br.com.locacao.imoveis.model.Clientes;
import br.com.locacao.imoveis.model.Imoveis;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContratosDTO {

    @NotBlank
    private Long id;
    @NotBlank
    private Float valorLocacao;
    @NotBlank
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;
    @NotBlank
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataFim;
    @NotBlank
    private Boolean ativo;
    @NotBlank
    private Clientes clientes;
    @NotBlank
    private Imoveis imovel;
}
