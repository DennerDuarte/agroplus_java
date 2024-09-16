package br.com.fiap.agroplus.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="T_TIPOS_CULTIVOS")
public class TipoCultivo {
	
	@Id
	@Column(name="ID_TIPO_CULTIVO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="DS_NOME_CULTIVO")
	@NotNull(message = "O nome do cultivo é obrigatório.")
	private String descricao;
	
	@ManyToMany(mappedBy = "tipoCultivos", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Cliente> clientes;

}
