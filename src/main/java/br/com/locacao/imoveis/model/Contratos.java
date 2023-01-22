package br.com.locacao.imoveis.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTRATOS")
public class Contratos {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long valorLocacao;

    private Date dataInicio;

    private Date dataFim;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes clientes;

    @ManyToOne
    @JoinColumn(name = "imoveis_id")
    private Imoveis imovel;
}
