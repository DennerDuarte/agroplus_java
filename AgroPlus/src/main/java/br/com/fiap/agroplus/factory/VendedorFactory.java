package br.com.fiap.agroplus.factory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.fiap.agroplus.dto.VendedorDTO;
import br.com.fiap.agroplus.entity.Vendedor;

public class VendedorFactory {
	
	private HistoricoVendasFactory historicoVendasFactory = new HistoricoVendasFactory();
	private RegiaoFactory regiaoFactory = new RegiaoFactory();
	
	public List<VendedorDTO> toDto(List<Vendedor> vendedores) {
	    return Optional.ofNullable(vendedores)
	            .map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
	            .orElse(Collections.emptyList());
	}
	
	public VendedorDTO toDto(Vendedor vendedor) {
		
		VendedorDTO dto = new VendedorDTO();
		
		dto.setId(vendedor.getId());
		dto.setNome(vendedor.getNome());
		dto.setContato(vendedor.getContato());
		dto.setVendas(historicoVendasFactory.toDto(vendedor.getVendas()));
		dto.setRegioes(regiaoFactory.toDto(vendedor.getRegioes()));
		
		return dto;
	}
	
	public List<Vendedor> toEntity(List<VendedorDTO> vendedores) {
	    return Optional.ofNullable(vendedores)
	            .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
	            .orElse(Collections.emptyList());
	}
	
	public Vendedor toEntity(VendedorDTO vendedor) {
		
		Vendedor entity = new Vendedor();
		
		entity.setId(vendedor.getId());
		entity.setNome(vendedor.getNome());
		entity.setContato(vendedor.getContato());
		entity.setVendas(historicoVendasFactory.toEntity(vendedor.getVendas()));
		entity.setRegioes(regiaoFactory.toEntity(vendedor.getRegioes()));
		
		return entity;
	}

}
