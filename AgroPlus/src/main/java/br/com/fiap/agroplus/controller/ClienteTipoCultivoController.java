package br.com.fiap.agroplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.agroplus.Service.TipoCultivoService;
import br.com.fiap.agroplus.dto.TipoCultivoDTO;

@Controller
@RequestMapping("/clientesTipoCultivo")
public class ClienteTipoCultivoController {

	@Autowired
	private TipoCultivoService service;

	@GetMapping("/{id}")
	public String listarTiposCultivos(@PathVariable Long id, Model model) {
		List<TipoCultivoDTO> tiposCultivos = service.buscaTiposCultivosPorCliente(id);
		List<TipoCultivoDTO> tiposCultivosDisponiveis = service.buscaTiposCultivos();
		
		
		model.addAttribute("clienteId", id);
		model.addAttribute("tiposCultivos", tiposCultivos);
		model.addAttribute("tiposCultivosDisponiveis", tiposCultivosDisponiveis);
		return "tipoCultivo";
	}

	@PostMapping("/adicionar")
	public String adicionarTipoCultivo(@RequestParam Long clienteId, @RequestParam Long cultivoId, Model model) {
		List<TipoCultivoDTO> tiposCultivos = service.salvaTiposCultivosPorCliente(cultivoId, clienteId);
		
		model.addAttribute("clienteId", clienteId);
		model.addAttribute("tiposCultivos", tiposCultivos);
		model.addAttribute("tiposCultivosDisponiveis", service.buscaTiposCultivos());
		
		return "tipoCultivo";
	}
	
    @PostMapping("/excluir/{id}")
    public String excluirTipoCultivo(@RequestParam Long clienteId, @RequestParam Long cultivoId, Model model) {
    	List<TipoCultivoDTO> tiposCultivos = service.removeTipoCultivoDeCliente(cultivoId, clienteId);
    	
    	model.addAttribute("clienteId", clienteId);
		model.addAttribute("tiposCultivos", tiposCultivos);
		model.addAttribute("tiposCultivosDisponiveis", service.buscaTiposCultivos());
		
        return "tipoCultivo";
    }

}
