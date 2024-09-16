package br.com.fiap.agroplus.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendedorDTO {
	
	private Long id;
	private String nome;
	private String contato;
	private List<HistoricoVendasDTO> vendas;
	private List<RegiaoDTO> regioes;

}
