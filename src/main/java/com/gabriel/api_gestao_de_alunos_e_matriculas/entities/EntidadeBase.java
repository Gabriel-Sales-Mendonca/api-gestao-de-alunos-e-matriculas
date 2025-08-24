package com.gabriel.api_gestao_de_alunos_e_matriculas.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntidadeBase {

    @CreatedDate
    private LocalDate dataInclusao;

    @LastModifiedDate
    private LocalDate dataAtualizacao;

}
