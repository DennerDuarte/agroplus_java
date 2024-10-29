package br.com.fiap.agroplus.Service;

import br.com.fiap.agroplus.entity.Login;
import br.com.fiap.agroplus.repository.LoginRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    private final LoginRepository repository;

    public LoginService(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Login> login = repository.findByUsername(username);
        if (login.isPresent()) {
            var usernameobj = login.get();
            return User.builder()
                    .username(usernameobj.getUsername())
                    .password(usernameobj.getPassword())
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found: " + username );
        }
    }


}
