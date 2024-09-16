package br.com.fiap.agroplus.factory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.fiap.agroplus.dto.RegiaoDTO;
import br.com.fiap.agroplus.entity.Regiao;

public class RegiaoFactory {

	public List<RegiaoDTO> toDto(List<Regiao> regioes) {
	    return Optional.ofNullable(regioes)
	            .map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList()))
	            .orElse(Collections.emptyList());
	}

	public RegiaoDTO toDto(Regiao regiao) {
		RegiaoDTO dto = new RegiaoDTO();
		dto.setId(regiao.getId());
		dto.setNome(regiao.getNome());
		return dto;
	}

	public List<Regiao> toEntity(List<RegiaoDTO> regioes) {
	    return Optional.ofNullable(regioes)
	            .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
	            .orElse(Collections.emptyList());
	}

	public Regiao toEntity(RegiaoDTO regiaodto) {
		Regiao entity = new Regiao();
		entity.setId(regiaodto.getId());
		entity.setNome(regiaodto.getNome());
		return entity;
	}

}
