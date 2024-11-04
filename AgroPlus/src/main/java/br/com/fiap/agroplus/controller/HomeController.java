package br.com.fiap.agroplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
//    @Autowired
//    private LoginRepository repository;
//
//    @Autowired
//    private PasswordEncoder encoder;

    @GetMapping("/")
    public String index() {
        return "home/index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }
    
//    @PostMapping("/cadastrar")
//    public String cadastrar(@RequestParam String usuario, @RequestParam String senha, Model model) {
//    	
//        if (repository.findByUsername(usuario).isPresent()) {
//            System.out.println("---------------Já existe-----------------");
//        }
//        
//        Login login = new Login();
//        login.setUsername(usuario);
//        login.setPassword(encoder.encode(senha));
//        
//        repository.save(login);
//        
//        return "login";
//    }

}
