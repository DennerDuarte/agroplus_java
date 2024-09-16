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

import br.com.fiap.agroplus.Service.ClienteService;
import br.com.fiap.agroplus.dto.ClienteDTO;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public String listarClientes(Model model) {
        List<ClienteDTO> clientes = service.getAll();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }
    
    @PostMapping("/adicionar")
    public String adicionarCliente(@RequestParam String nome, Model model) {
    	ClienteDTO cliente = new ClienteDTO();
    	cliente.setNome(nome);
        service.criarCliente(cliente);
        return "redirect:/clientes";
    }
    
    @PostMapping("/editar")
    public String editarCliente(@RequestParam Long id, @RequestParam String nome, Model model) {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setId(id);
        cliente.setNome(nome);
        service.updateCliente(id, cliente);
        return "redirect:/clientes";
    }
    
    @PostMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable Long id) {
    	service.deleteCliente(id);
        return "redirect:/clientes";
    }

}
