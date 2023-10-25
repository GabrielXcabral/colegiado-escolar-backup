package com.colegiado.sistemacolegiado.models.dto;


import com.colegiado.sistemacolegiado.models.Aluno;
import com.colegiado.sistemacolegiado.models.Assunto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriarAssuntoDTO {
    private int id;
    private String nome;

    public CriarAssuntoDTO (Assunto assunto){
        this.id = assunto.getId();
        this.nome = assunto.getNome();
    }
}
