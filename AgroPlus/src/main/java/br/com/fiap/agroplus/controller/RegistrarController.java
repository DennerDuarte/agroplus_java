package br.com.fiap.agroplus.controller;

import br.com.fiap.agroplus.entity.Login;
import br.com.fiap.agroplus.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrarController {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Login login) {
        if (repository.findByUsername(login.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existe");
        }

        login.setPassword(encoder.encode(login.getPassword()));
        repository.save(login);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso");
    }
}
