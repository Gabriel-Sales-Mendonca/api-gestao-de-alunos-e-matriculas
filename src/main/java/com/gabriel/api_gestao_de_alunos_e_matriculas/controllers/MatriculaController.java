package com.gabriel.api_gestao_de_alunos_e_matriculas.controllers;

import com.gabriel.api_gestao_de_alunos_e_matriculas.dto.MatriculaDTO;
import com.gabriel.api_gestao_de_alunos_e_matriculas.entities.Matricula;
import com.gabriel.api_gestao_de_alunos_e_matriculas.mapper.MatriculaMapper;
import com.gabriel.api_gestao_de_alunos_e_matriculas.services.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> findAllByAlunoId(@RequestParam("alunoId") Long alunoId) {
        List<Matricula> matriculas = this.matriculaService.findAllByAlunoId(alunoId);

        List<MatriculaDTO> matriculasDTO = matriculas
                .stream()
                .map(matricula -> MatriculaMapper.toDTO(matricula))
                .toList();

        return ResponseEntity.ok(matriculasDTO);
    }

}
