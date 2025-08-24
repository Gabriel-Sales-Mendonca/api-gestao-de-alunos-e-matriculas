package com.gabriel.api_gestao_de_alunos_e_matriculas.dto;

import java.time.LocalDate;
import java.util.Set;

public record AlunoResponseDTO(
        Long id,
        String nome,
        String telefone,
        LocalDate dataNascimento,
        Set<MatriculaDTO> matriculas
) {
}
