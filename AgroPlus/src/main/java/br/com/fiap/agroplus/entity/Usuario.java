package br.com.fiap.agroplus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "T_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_USUARIO")
    private Long id;

    @Column(name = "USUARIO", nullable = false, length = 200)
    private String username;

    @Column(name = "SENHA", nullable = false)
    private String password;
    
    @Column(name = "ROLE", nullable = false)
    private String role;

}
