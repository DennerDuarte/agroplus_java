package br.com.fiap.agroplus.factory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.fiap.agroplus.dto.TipoCultivoDTO;
import br.com.fiap.agroplus.entity.TipoCultivo;

public class TipoCultivoFactory {

	public List<TipoCultivoDTO> toDto(List<TipoCultivo> tipoCultivos) {
	    return Optional.ofNullable(tipoCultivos)
	            .map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
	            .orElse(Collections.emptyList());
	}

	public TipoCultivoDTO toDto(TipoCultivo tipocultivo) {
		
		if(tipocultivo == null) {
			return null;
		}
		
		TipoCultivoDTO dto = new TipoCultivoDTO();
		dto.setId(tipocultivo.getId());
		dto.setDescricao(tipocultivo.getDescricao());
		return dto;
	}
	
	public List<TipoCultivo> toEntity(List<TipoCultivoDTO> tipoCultivos) {
	    return Optional.ofNullable(tipoCultivos)
	            .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
	            .orElse(Collections.emptyList());
	}

	public TipoCultivo toEntity(TipoCultivoDTO tipocultivo) {
		TipoCultivo entity = new TipoCultivo();
		entity.setId(tipocultivo.getId());
		entity.setDescricao(tipocultivo.getDescricao());
		return entity;
	}

}
