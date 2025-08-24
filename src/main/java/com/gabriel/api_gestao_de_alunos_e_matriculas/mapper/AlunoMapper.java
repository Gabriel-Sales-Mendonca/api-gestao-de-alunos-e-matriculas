package com.gabriel.api_gestao_de_alunos_e_matriculas.mapper;

import com.gabriel.api_gestao_de_alunos_e_matriculas.dto.AlunoRequestDTO;
import com.gabriel.api_gestao_de_alunos_e_matriculas.dto.AlunoResponseDTO;
import com.gabriel.api_gestao_de_alunos_e_matriculas.dto.MatriculaDTO;
import com.gabriel.api_gestao_de_alunos_e_matriculas.entities.Aluno;
import com.gabriel.api_gestao_de_alunos_e_matriculas.entities.Matricula;

import java.util.stream.Collectors;

public class AlunoMapper {

    public static Aluno toEntity(AlunoRequestDTO alunoRequestDTO) {
        for (MatriculaDTO matriculaDTO : alunoRequestDTO.matriculas()) {
            System.out.println("Matrícula DTO: " + matriculaDTO);
        }

        Aluno aluno = new Aluno();

        aluno.setNome(alunoRequestDTO.nome());
        aluno.setTelefone(alunoRequestDTO.telefone());
        aluno.setDataNascimento(alunoRequestDTO.dataNascimento());
        aluno.setMatriculas(alunoRequestDTO.matriculas()
                .stream()
                .map(MatriculaMapper::toEntity).collect(Collectors.toSet()));

        for (Matricula matricula : aluno.getMatriculas()) {
            System.out.println(matricula);
        }

        return aluno;
    }

    public static AlunoResponseDTO toDTO(Aluno aluno) {
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getTelefone(),
                aluno.getDataNascimento(),
                aluno.getMatriculas()
                        .stream()
                        .map(MatriculaMapper::toDTO).collect(Collectors.toSet())
        );
    }

}
