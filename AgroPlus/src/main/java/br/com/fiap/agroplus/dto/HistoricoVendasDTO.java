package br.com.fiap.agroplus.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class HistoricoVendasDTO {

	private Long id;
	private Long idVendedor;
	private Long idCliente;
	private LocalDate dataVenda;
	private Integer quantidade;
	private Double valorTotal;

}
