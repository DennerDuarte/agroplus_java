package br.com.fiap.agroplus.factory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.fiap.agroplus.dto.HistoricoVendasDTO;
import br.com.fiap.agroplus.entity.HistoricoVendas;

public class HistoricoVendasFactory {
	
	public List<HistoricoVendasDTO> toDto(List<HistoricoVendas> vendas) {
	    return Optional.ofNullable(vendas)
	            .map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
	            .orElse(Collections.emptyList());
	}

	public HistoricoVendasDTO toDto(HistoricoVendas venda) {
		
		HistoricoVendasDTO dto = new HistoricoVendasDTO();
		
		dto.setId(venda.getId());
		dto.setIdCliente(venda.getIdCliente());
		dto.setIdVendedor(venda.getIdVendedor());
		dto.setDataVenda(venda.getDataVenda());
		dto.setQuantidade(venda.getQuantidade());
		dto.setValorTotal(venda.getValorTotal());
		
		return dto;
	}
	
	public List<HistoricoVendas> toEntity(List<HistoricoVendasDTO> vendas) {
	    return Optional.ofNullable(vendas)
	            .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
	            .orElse(Collections.emptyList());
	}
	
	public HistoricoVendas toEntity(HistoricoVendasDTO venda) {
		
		HistoricoVendas entity = new HistoricoVendas();
		
		entity.setId(venda.getId());
		entity.setIdCliente(venda.getIdCliente());
		entity.setIdVendedor(venda.getIdVendedor());
		entity.setDataVenda(venda.getDataVenda());
		entity.setQuantidade(venda.getQuantidade());
		entity.setValorTotal(venda.getValorTotal());
		
		return entity;
	}

}
