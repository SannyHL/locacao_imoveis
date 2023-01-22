package br.com.locacao.imoveis.repository;

import br.com.locacao.imoveis.model.Imoveis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ImoveisRepository extends JpaRepository<Imoveis, Long>{

    @Transactional
    @Modifying
    @Query(value = "UPDATE IMOVEIS SET ativo = FALSE WHERE id =:id", nativeQuery = true)
    void deletarImovel(@Param("id") Long id);

    @Query(value = "SELECT * FROM IMOVEIS WHERE ativo = TRUE", nativeQuery = true)
    List<Imoveis> buscarImoveisAtivos();

    @Query(value = "SELECT * FROM IMOVEIS WHERE ativo = TRUE AND locado = FALSE", nativeQuery = true)
    List<Imoveis> buscarImoveisAtivosENaoLocados();

    @Query(value = "SELECT * FROM IMOVEIS WHERE ativo = FALSE", nativeQuery = true)
    List<Imoveis> buscarImoveisInativos();

    @Query(value = "SELECT * FROM IMOVEIS WHERE locado = TRUE", nativeQuery = true)
    List<Imoveis> buscarImoveisLocados();

    @Query(value = "SELECT * FROM IMOVEIS WHERE locado = FALSE", nativeQuery = true)
    List<Imoveis> buscarImoveisNaoLocados();
}
