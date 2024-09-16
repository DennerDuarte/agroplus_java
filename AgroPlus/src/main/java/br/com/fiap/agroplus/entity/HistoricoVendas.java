package br.com.fiap.agroplus.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="T_HISTORICO_VENDAS")
public class HistoricoVendas {

	@Id
	@Column(name="ID_VENDA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="ID_VENDEDOR")
	private Long idVendedor;

	@Column(name="ID_CLIENTE")
	private Long idCliente;

	@Column(name="DT_VENDA")
	private LocalDate dataVenda;

	@Min(0)
	@Column(name="NR_QUANTIDADE")
	private Integer quantidade;

	@Min(0)
	@Column(name="NR_VALOR_TOTAL")
	private Double valorTotal;
	
	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", insertable = false, updatable = false)
	})
	private Cliente cliente;

	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "ID_VENDEDOR", referencedColumnName = "ID_VENDEDOR", insertable = false, updatable = false)
	})
	private Vendedor vendedor;

}
