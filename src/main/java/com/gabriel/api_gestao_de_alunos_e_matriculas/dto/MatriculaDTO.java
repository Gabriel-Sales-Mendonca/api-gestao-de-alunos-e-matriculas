package com.gabriel.api_gestao_de_alunos_e_matriculas.dto;

import java.time.LocalDate;

public record MatriculaDTO(
        String codigoMatricula,
        String nomeCurso,
        LocalDate dataInicio
) {
}
