package com.gabriel.api_gestao_de_alunos_e_matriculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiGestaoDeAlunosEMatriculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGestaoDeAlunosEMatriculasApplication.class, args);
	}

}
