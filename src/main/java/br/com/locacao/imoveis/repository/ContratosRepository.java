package br.com.locacao.imoveis.repository;

import br.com.locacao.imoveis.model.Contratos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratosRepository extends JpaRepository<Contratos, Long>{
}
