package br.com.fiap.agroplus.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.agroplus.Service.TipoCultivoService;
import br.com.fiap.agroplus.dto.TipoCultivoDTO;

@RestController
@RequestMapping("/api/tiposCultivos")
public class TipoCultivoResource {
	
	@Autowired
	private TipoCultivoService service;
	
    @GetMapping
    public List<TipoCultivoDTO> listarTiposCultivos() {
    	return service.buscaTiposCultivos();
    }
    
    @PostMapping
    public TipoCultivoDTO listarTiposCultivos(@RequestBody TipoCultivoDTO tipoCultivo) {
    	return service.salvaTipoCultivo(tipoCultivo);
    }

}
