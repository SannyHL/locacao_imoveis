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
@Table(name = "ENDERECOS")
public class Enderecos {

    @Id
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

}
