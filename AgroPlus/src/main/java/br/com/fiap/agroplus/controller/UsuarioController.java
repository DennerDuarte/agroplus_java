package br.com.fiap.agroplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.agroplus.Service.UsuarioService;
import br.com.fiap.agroplus.entity.Usuario;
import br.com.fiap.agroplus.security.CustomUserDetailsService;

@Controller
@RequestMapping("/login")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PasswordEncoder encoder;
	
    @Autowired
    private CustomUserDetailsService userDetailsService;


	@PostMapping("/cadastrar")
	public String cadastrarUsuario(@RequestParam String usuario, @RequestParam String senha) {
		Usuario novoUsuario = new Usuario(); // Certifique-se de que sua classe Usuario possui um construtor vazio
		novoUsuario.setUsername(usuario);
		novoUsuario.setPassword(encoder.encode(senha)); // Certifique-se de tratar a senha adequadamente (hash, por
														// exemplo)

//		try {
//			usuarioService.cadastrarUsuario(novoUsuario);
//			//redirectAttributes.addFlashAttribute("MSG_SUCCESS", "Usuário cadastrado com sucesso!");
//			return "redirect:/login"; // Redireciona após o cadastro
//		} catch (Exception e) {
//			//redirectAttributes.addFlashAttribute("MSG_ERROR", e.getMessage());
//			return "redirect:/cadastro"; // Redireciona em caso de erro
//		}
		
		usuarioService.cadastrarUsuario(novoUsuario);
		
		
		return "login";
	}
	
//	@PostMapping("/entrar")
//	public String entrar(@RequestParam String usuario, @RequestParam String senha) {
//
//		Usuario user = usuarioService.buscarPorUsername(usuario);
//		if(!user.getPassword().equals(encoder.encode(senha)))
//			return "login";
//		
//		
//		return "home/index";
//	}
	
	
	
	@PostMapping("/entrar")
	public String entrar(@RequestParam String usuario, @RequestParam String senha) {

	    UserDetails userDetails = userDetailsService.loadUserByUsername(usuario);

	    if (encoder.matches(senha, userDetails.getPassword())) {
	        UsernamePasswordAuthenticationToken authToken = 
	            new UsernamePasswordAuthenticationToken(userDetails, senha, userDetails.getAuthorities());
	        SecurityContextHolder.getContext().setAuthentication(authToken);
	        
	        return "home/index";
	    } else {
	    	return "login";
	    }
	}

}
