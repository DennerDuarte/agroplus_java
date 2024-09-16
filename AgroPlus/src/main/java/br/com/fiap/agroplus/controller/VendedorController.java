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

import br.com.fiap.agroplus.Service.VendedorService;
import br.com.fiap.agroplus.dto.VendedorDTO;

@Controller
@RequestMapping("/vendedores")
public class VendedorController {
	
	@Autowired
    private VendedorService service;

    @GetMapping
    public String listarVendedores(Model model) {
        List<VendedorDTO> vendedores = service.getAll();
        model.addAttribute("vendedores", vendedores);
        return "vendedores";
    }
    
    @PostMapping("/adicionar")
    public String adicionarVendedor(@RequestParam String nome, @RequestParam String contato,
    		Model model) {
    	VendedorDTO vendedor = new VendedorDTO();
    	vendedor.setNome(nome);
    	vendedor.setContato(contato);
        service.criarVendedor(vendedor);
        return "redirect:/vendedores";
    }
    
    @PostMapping("/editar")
    public String editarVendedor(@RequestParam Long id, @RequestParam String nome, @RequestParam String contato,
    		Model model) {
        VendedorDTO vendedor = new VendedorDTO();
        vendedor.setId(id);
        vendedor.setNome(nome);
        vendedor.setContato(contato);
        service.updateVendedor(id, vendedor);
        return "redirect:/vendedores";
    }
    
    @PostMapping("/excluir/{id}")
    public String excluirVendedor(@PathVariable Long id) {
    	service.deleteVendedor(id);
        return "redirect:/vendedores";
    }


}
