package br.com.locacao.imoveis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "IMOVEIS")
public class Imoveis {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long numeroCasa;
    private Boolean locado;

    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Enderecos endereco;

}
