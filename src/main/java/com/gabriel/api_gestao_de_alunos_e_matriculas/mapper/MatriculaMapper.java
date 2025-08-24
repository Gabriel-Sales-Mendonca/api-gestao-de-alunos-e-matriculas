package com.gabriel.api_gestao_de_alunos_e_matriculas.mapper;

import com.gabriel.api_gestao_de_alunos_e_matriculas.dto.MatriculaDTO;
import com.gabriel.api_gestao_de_alunos_e_matriculas.entities.Matricula;

public class MatriculaMapper {

    public static Matricula toEntity(MatriculaDTO matriculaDTO) {
        Matricula matricula = new Matricula();

        matricula.setCodigoMatricula(matriculaDTO.codigoMatricula());
        matricula.setNomeCurso(matriculaDTO.nomeCurso());
        matricula.setDataInicio(matriculaDTO.dataInicio());

        return matricula;
    }

    public static MatriculaDTO toDTO(Matricula matricula) {
        return new MatriculaDTO(
                matricula.getCodigoMatricula(),
                matricula.getNomeCurso(),
                matricula.getDataInicio()
        );
    }

}
