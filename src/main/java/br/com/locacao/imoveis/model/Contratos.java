package br.com.locacao.imoveis.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

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

    @NonNull
    private Float valorLocacao;

    @NonNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;
    @NonNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataFim;
    @NonNull
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes clientes;

    @ManyToOne
    @JoinColumn(name = "imoveis_id")
    private Imoveis imovel;
}
