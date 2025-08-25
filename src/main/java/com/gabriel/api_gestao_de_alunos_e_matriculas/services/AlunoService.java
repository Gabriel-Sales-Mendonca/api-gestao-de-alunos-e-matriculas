package com.gabriel.api_gestao_de_alunos_e_matriculas.services;

import com.gabriel.api_gestao_de_alunos_e_matriculas.entities.Aluno;
import com.gabriel.api_gestao_de_alunos_e_matriculas.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno criar(Aluno aluno) {
        aluno.getMatriculas()
                .stream()
                .forEach(matricula -> {
                    matricula.setAluno(aluno);
                });

        return this.alunoRepository.save(aluno);
    }

    public List<Aluno> findAll() {
        return this.alunoRepository.findAll();
    }

}
