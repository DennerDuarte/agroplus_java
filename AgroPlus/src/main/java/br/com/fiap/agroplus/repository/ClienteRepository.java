package br.com.fiap.agroplus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.agroplus.entity.Cliente;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
