package com.gabriel.api_gestao_de_alunos_e_matriculas.controllers;

import com.gabriel.api_gestao_de_alunos_e_matriculas.dto.AlunoRequestDTO;
import com.gabriel.api_gestao_de_alunos_e_matriculas.dto.AlunoResponseDTO;
import com.gabriel.api_gestao_de_alunos_e_matriculas.entities.Aluno;
import com.gabriel.api_gestao_de_alunos_e_matriculas.mapper.AlunoMapper;
import com.gabriel.api_gestao_de_alunos_e_matriculas.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> create(@RequestBody AlunoRequestDTO alunoRequestDTO) {
        Aluno alunoParaCriar = AlunoMapper.toEntity(alunoRequestDTO);
        Aluno alunoCreated = this.alunoService.criar(alunoParaCriar);

        return ResponseEntity.ok(AlunoMapper.toDTO(alunoCreated));
    }

}
