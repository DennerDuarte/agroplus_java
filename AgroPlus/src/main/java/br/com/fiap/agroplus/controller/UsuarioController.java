package br.com.fiap.agroplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.agroplus.RabbitMQ.MessageSender;
import br.com.fiap.agroplus.Service.UsuarioService;
import br.com.fiap.agroplus.entity.Usuario;

@Controller
@RequestMapping("/login")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private MessageSender messageSender;

	@PostMapping("/cadastrar")
	public String cadastrarUsuario(@RequestParam String usuario, @RequestParam String senha) {
		Usuario novoUsuario = new Usuario();
		novoUsuario.setUsername(usuario);
		novoUsuario.setPassword(encoder.encode(senha));
		novoUsuario.setRole("USER");
		
		usuarioService.cadastrarUsuario(novoUsuario);
		
		messageSender.sendMessage("Usuário cadastrado!");
		
		
		return "login";
	}

}
