package br.com.fiap.agroplus.repository;

import br.com.fiap.agroplus.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    @Query("SELECT l FROM Login l WHERE l.username = :username")
    Optional<Login> findByUsername(@Param("username") String username);

}
