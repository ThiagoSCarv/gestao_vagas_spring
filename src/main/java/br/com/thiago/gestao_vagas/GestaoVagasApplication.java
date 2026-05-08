package br.com.thiago.gestao_vagas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Ponto de entrada da aplicação Spring Boot
@SpringBootApplication
public class GestaoVagasApplication {

	public static void main(String[] args) {
		// Inicializa o contexto do Spring e sobe o servidor embutido
		SpringApplication.run(GestaoVagasApplication.class, args);
	}

}
