package br.com.fiap.agroplus.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.agroplus.entity.Usuario;
import br.com.fiap.agroplus.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository loginRepository;
    
    public List<Usuario> getAll(){
    	return loginRepository.findAll();
    }

    public Usuario buscarPorUsername(String username) {
        return loginRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
    
    public Usuario cadastrarUsuario(Usuario usuario) {
        if (loginRepository.findByUsername(usuario.getUsername()).isPresent()) {
            throw new RuntimeException("Usuário já cadastrado");
        }
        usuario.setRole("USER");
        return loginRepository.save(usuario);
    }
}
