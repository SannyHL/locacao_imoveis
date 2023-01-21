package br.com.locacao.imoveis.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "CLIENTES")
public class Clientes {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NonNull
    private String nome;

    @NonNull
    private Long numeroCasa;

    @NonNull
    @Column(unique = true)
    private String cpfCnpj;

    @Email
    @NonNull
    @Column(unique = true)
    private String email;
    @NonNull
    @Column(unique = true)
    private String telefone;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_cep")
    private Enderecos endereco;
}
