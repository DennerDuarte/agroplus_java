package br.com.fiap.agroplus.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

	private Long id;
	private String nome;
	private List<TipoCultivoDTO> tipoCultivos;
	private List<HistoricoVendasDTO> vendas;
}
