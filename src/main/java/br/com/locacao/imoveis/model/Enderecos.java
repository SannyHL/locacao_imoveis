package br.com.locacao.imoveis.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String logradouro;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String bairro;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String localidade;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String uf;

}
