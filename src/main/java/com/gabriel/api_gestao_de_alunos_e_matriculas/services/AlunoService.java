package com.gabriel.api_gestao_de_alunos_e_matriculas.services;

import com.gabriel.api_gestao_de_alunos_e_matriculas.entities.Aluno;
import com.gabriel.api_gestao_de_alunos_e_matriculas.repositories.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno create(Aluno aluno) {
        aluno.getMatriculas()
                .stream()
                .forEach(matricula -> {
                    matricula.setAluno(aluno);
                });

        return this.alunoRepository.save(aluno);
    }

    public Aluno findById(Long id) {
        return this.alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado, ID: " + id));
    }

    public List<Aluno> findAll() {
        return this.alunoRepository.findAll();
    }

    public Aluno update(Long id, Aluno dadosAluno) {
        Aluno alunoDB = this.findById(id);

        alunoDB.setNome(dadosAluno.getNome());
        alunoDB.setTelefone(dadosAluno.getTelefone());
        alunoDB.setDataNascimento(dadosAluno.getDataNascimento());

        dadosAluno.getMatriculas()
                        .stream()
                        .forEach(matricula -> {
                            matricula.setAluno(alunoDB);
                        });

        alunoDB.setMatriculas(dadosAluno.getMatriculas());

        return this.alunoRepository.save(alunoDB);
    }

}
