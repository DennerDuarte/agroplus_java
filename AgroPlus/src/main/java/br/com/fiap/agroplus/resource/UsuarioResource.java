package br.com.fiap.agroplus.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.agroplus.Service.UsuarioService;
import br.com.fiap.agroplus.entity.Usuario;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {
	
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public List<Usuario> obterUsuario() {
        return usuarioService.getAll();
    }

    @GetMapping("/{username}")
    public Usuario obterUsuario(@PathVariable String username) {
        return usuarioService.buscarPorUsername(username);
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
    	usuario.setRole("VENDEDOR");
        return usuarioService.cadastrarUsuario(usuario);
    }

}
