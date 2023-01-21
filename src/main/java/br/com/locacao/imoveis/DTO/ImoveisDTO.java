package br.com.locacao.imoveis.DTO;


import br.com.locacao.imoveis.model.Enderecos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImoveisDTO {

    private Long id;
    private Long numeroCasa;
    private Boolean locado;
    private Enderecos endereco;

    private Boolean ativo;
}
