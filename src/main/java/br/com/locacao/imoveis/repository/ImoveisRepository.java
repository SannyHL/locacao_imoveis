package br.com.locacao.imoveis.repository;

import br.com.locacao.imoveis.model.Imoveis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImoveisRepository extends JpaRepository<Imoveis, Long>{
}
