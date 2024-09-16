package br.com.fiap.agroplus.factory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.fiap.agroplus.dto.ClienteDTO;
import br.com.fiap.agroplus.entity.Cliente;

public class ClienteFactory {
	
	private TipoCultivoFactory tipoCultivoFactory = new TipoCultivoFactory();
	private HistoricoVendasFactory historicoVendasFactory = new HistoricoVendasFactory();
	
	public List<ClienteDTO> toDto(List<Cliente> clientes) {
	    return Optional.ofNullable(clientes)
	            .map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
	            .orElse(Collections.emptyList());
	}

	public ClienteDTO toDto(Cliente cliente) {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(cliente.getId());
		dto.setNome(cliente.getNome());
		//List<TipoCultivo> tipo = cliente.getTipoCultivos();
		dto.setTipoCultivos(tipoCultivoFactory.toDto(cliente.getTipoCultivos()));
		dto.setVendas(historicoVendasFactory.toDto(cliente.getVendas()));
		return dto;
	}

	public List<Cliente> toEntity(List<ClienteDTO> clientes) {
	    return Optional.ofNullable(clientes)
	            .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
	            .orElse(Collections.emptyList());
	}

	public Cliente toEntity(ClienteDTO cliente) {
		Cliente entity = new Cliente();
		entity.setId(cliente.getId());
		entity.setNome(cliente.getNome());
		entity.setTipoCultivos(tipoCultivoFactory.toEntity(cliente.getTipoCultivos()));
		entity.setVendas(historicoVendasFactory.toEntity(cliente.getVendas()));
		return entity;
	}

}
