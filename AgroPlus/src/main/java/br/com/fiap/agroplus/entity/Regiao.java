package br.com.fiap.agroplus.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="T_REGIAO")
public class Regiao {
	
	@Id
	@Column(name="ID_REGIAO")
	private Long id;
	
	@Column(name="DS_NOME_REGIAO")
	@NotNull(message = "O nome da região é obrigatório.")
	private String nome;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "T_VENDEDOR_REGIAO",
			joinColumns = @JoinColumn(name = "ID_REGIAO"),
			inverseJoinColumns = @JoinColumn(name = "ID_VENDEDOR"))
	private List<Vendedor> vendedores;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumns(value = {
		@JoinColumn(name = "ID_REGIAO", referencedColumnName = "ID_REGIAO", insertable = false, updatable = false)
	})
	private List<InfoRegiao> infosRegiao;

}
