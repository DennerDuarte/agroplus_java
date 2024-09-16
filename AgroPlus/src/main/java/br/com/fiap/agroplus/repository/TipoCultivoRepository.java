package br.com.fiap.agroplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.agroplus.entity.TipoCultivo;

@Repository
public interface TipoCultivoRepository extends CrudRepository<TipoCultivo, Long> {
	
	@Query("SELECT tc FROM TipoCultivo tc JOIN tc.clientes c WHERE c.id = :clienteId")
    List<TipoCultivo> findByClienteId(@Param("clienteId") Long clienteId);

}
