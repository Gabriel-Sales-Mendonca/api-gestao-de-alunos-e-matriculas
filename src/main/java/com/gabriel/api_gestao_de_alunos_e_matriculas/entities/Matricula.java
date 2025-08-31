package com.gabriel.api_gestao_de_alunos_e_matriculas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb-matricula")
@NoArgsConstructor
@AllArgsConstructor
public class Matricula extends EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String codigoMatricula;

    @Column(unique = true)
    private String nomeCurso;

    private LocalDate dataInicio;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return Objects.equals(id, matricula.id) && Objects.equals(codigoMatricula, matricula.codigoMatricula) && Objects.equals(nomeCurso, matricula.nomeCurso) && Objects.equals(dataInicio, matricula.dataInicio) && Objects.equals(aluno, matricula.aluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoMatricula, nomeCurso, dataInicio, aluno);
    }
}
