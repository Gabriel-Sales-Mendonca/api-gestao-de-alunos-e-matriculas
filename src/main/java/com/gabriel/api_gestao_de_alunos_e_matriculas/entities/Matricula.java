package com.gabriel.api_gestao_de_alunos_e_matriculas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb-matricula")
public class Matricula extends EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoMatricula;
    private String nomeCurso;
    private LocalDate dataInicio;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

}
