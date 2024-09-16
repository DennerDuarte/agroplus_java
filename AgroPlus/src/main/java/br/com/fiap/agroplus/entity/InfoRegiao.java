package br.com.fiap.agroplus.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="T_INFOS_REGIAO")
public class InfoRegiao {

	@Id
	@Column(name="ID_INFOS_REGIAO")
	private Long id;

	@Column(name="ID_CLIENTE")
	@NotNull(message = "O id do cliente é obrigatório.")
	private Long id_cliente;

	@Column(name="NR_TEMPERATURA")
	private Double temperatura;
	
	@Column(name="NR_UMIDADE")
	private Double umidade;
	
	@Column(name="NR_PRECIPITACAO")
	private Double precipitacao;
	
	@Column(name="DT_INFO")
	private LocalDate dataInfo;
}
