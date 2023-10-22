package com.colegiado.sistemacolegiado.models.dto;

import com.colegiado.sistemacolegiado.models.Aluno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {
    private int id;
    private String nome;
    private String fone;
    private String matricula;

    public AlunoDTO (Aluno aluno){
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.fone = aluno.getFone();
        this.matricula = aluno.getMatricula();
    }
}
