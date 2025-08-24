package com.gabriel.api_gestao_de_alunos_e_matriculas.repositories;

import com.gabriel.api_gestao_de_alunos_e_matriculas.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
