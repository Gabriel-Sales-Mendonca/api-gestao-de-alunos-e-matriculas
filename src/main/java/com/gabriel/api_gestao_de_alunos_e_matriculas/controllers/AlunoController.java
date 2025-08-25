package com.gabriel.api_gestao_de_alunos_e_matriculas.controllers;

import com.gabriel.api_gestao_de_alunos_e_matriculas.dto.AlunoRequestDTO;
import com.gabriel.api_gestao_de_alunos_e_matriculas.dto.AlunoResponseDTO;
import com.gabriel.api_gestao_de_alunos_e_matriculas.entities.Aluno;
import com.gabriel.api_gestao_de_alunos_e_matriculas.mapper.AlunoMapper;
import com.gabriel.api_gestao_de_alunos_e_matriculas.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> findAll() {
        List<Aluno> alunos = this.alunoService.findAll();
        List<AlunoResponseDTO> alunosResponseDTO = alunos.stream().map(aluno -> AlunoMapper.toDTO(aluno)).toList();

        return ResponseEntity.ok(alunosResponseDTO);
    }

}
