package br.com.locacao.imoveis.repository;

import br.com.locacao.imoveis.model.Contratos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ContratosRepository extends JpaRepository<Contratos, Long>{

    @Transactional
    @Modifying
    @Query(value = "UPDATE CONTRATOS SET ativo = FALSE WHERE id =:id", nativeQuery = true)
    void deleteContratoPorId(@Param("id") Long id);
}
