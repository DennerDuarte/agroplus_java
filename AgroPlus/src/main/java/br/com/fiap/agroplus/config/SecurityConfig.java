package br.com.fiap.agroplus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import br.com.fiap.agroplus.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
    @Autowired
    private CustomUserDetailsService userDetailsService;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(authz -> authz
//                .anyRequest().authenticated() // Exige autenticação para todas as requisições
//            )
//            .formLogin(withDefaults()); // Habilita o formulário de login com configurações padrão
//        return http.build();
//    }
	
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(authz -> authz
//            		.requestMatchers("/", "/cadastro", "/login/cadastrar", "/api/**", "/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
//                .anyRequest().authenticated()//////////////////
//            ).csrf().disable()
//            .formLogin(withDefaults())
////            .headers(headers -> headers
////                .frameOptions().sameOrigin()
////            )
//            ;
//
//        return http.build();
//    }

    
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/", "/cadastro", "/login/cadastrar", "/login/entrar", "/api/**", "/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
                .anyRequest().authenticated()
            )
            .csrf().disable() // Desativa CSRF (não recomendado para produção sem considerar os riscos)
            .formLogin(form -> form
                .loginPage("/login") // Define a URL da página de login personalizada
                .permitAll() // Permite acesso à página de login para todos
                .defaultSuccessUrl("/", true) // Define a URL de redirecionamento após login bem-sucedido
                .failureUrl("/login?error=true") // Define a URL para redirecionar em caso de falha no login
            )
            .logout(logout -> logout
                .logoutUrl("/logout") // URL para logout
                .logoutSuccessUrl("/login?logout=true") // Redireciona após logout bem-sucedido
                .permitAll()
            )
            .userDetailsService(userDetailsService);;

        return http.build();
    }





//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withUsername("user")
//            .password(passwordEncoder().encode("password"))
//            .roles("USER")
//            .build();
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usar BCrypt para codificar senhas
    }
}
