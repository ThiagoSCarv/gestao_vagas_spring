package br.com.thiago.gestao_vagas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// Classe central de configuração do Spring Security
@Configuration
public class SecurityConfig {

    // Define as regras de autorização HTTP da aplicação
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // desabilita CSRF (adequado para APIs REST stateless)
            .authorizeHttpRequests(auth -> auth
                // rotas de cadastro e login são públicas — não exigem autenticação
                .requestMatchers("/candidate", "/company").permitAll()
                .requestMatchers("/login/company").permitAll()
                .requestMatchers("/login/candidate").permitAll()
                // qualquer outra rota exige usuário autenticado
                .anyRequest().authenticated()
            );
        return http.build();
    }

    // Registra o encoder BCrypt como bean para ser injetado nos use cases
    // BCrypt aplica hash com salt aleatório, tornando cada senha única mesmo que o valor seja igual
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
