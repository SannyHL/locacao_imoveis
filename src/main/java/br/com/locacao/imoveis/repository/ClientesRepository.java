package br.com.locacao.imoveis.repository;

import br.com.locacao.imoveis.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
