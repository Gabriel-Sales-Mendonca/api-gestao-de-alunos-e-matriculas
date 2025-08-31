package com.gabriel.api_gestao_de_alunos_e_matriculas.services;

import com.gabriel.api_gestao_de_alunos_e_matriculas.entities.Aluno;
import com.gabriel.api_gestao_de_alunos_e_matriculas.entities.Matricula;
import com.gabriel.api_gestao_de_alunos_e_matriculas.repositories.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoService alunoService;

    public MatriculaService(MatriculaRepository matriculaRepository, AlunoService alunoService) {
        this.matriculaRepository = matriculaRepository;
        this.alunoService = alunoService;
    }

    public List<Matricula> findAllByAlunoId(Long id) {
        Aluno aluno = this.alunoService.findById(id);
        return this.matriculaRepository.findAllByAluno(aluno);
    }

}
