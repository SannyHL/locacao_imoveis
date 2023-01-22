package br.com.locacao.imoveis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

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

    @NonNull
    private Long numeroCasa;

    @NonNull
    private Boolean locado;

    @NonNull
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "endereco_cep")
    private Enderecos endereco;
}
