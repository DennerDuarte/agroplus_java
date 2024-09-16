package br.com.fiap.agroplus.repository;

import br.com.fiap.agroplus.entity.Vendedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Long> {


}
