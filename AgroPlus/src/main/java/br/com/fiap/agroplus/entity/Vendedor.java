package br.com.fiap.agroplus.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="T_VENDEDORES")
public class Vendedor {
	
	@Id
	@Column(name="ID_VENDEDOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="DS_NOME")
	private String nome;
	
	@Column(name="DS_CONTATO")
	private String contato;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "vendedor")
	private List<HistoricoVendas> vendas;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "vendedores")
	private List<Regiao> regioes;

}
