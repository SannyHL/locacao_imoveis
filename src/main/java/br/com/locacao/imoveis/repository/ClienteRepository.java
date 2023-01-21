package br.com.locacao.imoveis.repository;

import br.com.locacao.imoveis.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
