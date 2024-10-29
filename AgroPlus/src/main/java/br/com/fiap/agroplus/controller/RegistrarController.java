package br.com.fiap.agroplus.controller;

import br.com.fiap.agroplus.entity.Login;
import br.com.fiap.agroplus.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrarController {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/signup")
    public String signup(@RequestBody Login login) {
        login.setPassword(encoder.encode(login.getPassword()));
        repository.save(login);

        return "redirect:/login";
    }

}
