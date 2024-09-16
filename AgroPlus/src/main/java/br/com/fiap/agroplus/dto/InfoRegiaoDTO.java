package br.com.fiap.agroplus.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class InfoRegiaoDTO {

    private Long id;
    private Long id_cliente;
    private Double temperatura;
    private Double umidade;
    private Double precipitacao;
    private LocalDate dataInfo;
}
