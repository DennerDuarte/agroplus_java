package br.com.fiap.agroplus.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="T_CLIENTES")
public class Cliente {

	@Id
	@Column(name="ID_CLIENTE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="DS_NOME_CLIENTE")
	private String nome;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
        name = "T_CLIENTE_TIPOCULTIVO",
        joinColumns = @JoinColumn(name = "ID_CLIENTE"),
        inverseJoinColumns = @JoinColumn(name = "ID_TIPO_CULTIVO")
    )
    private List<TipoCultivo> tipoCultivos;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	private List<HistoricoVendas> vendas;

}
