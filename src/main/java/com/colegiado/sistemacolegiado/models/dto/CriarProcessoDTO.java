package com.colegiado.sistemacolegiado.models.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CriarProcessoDTO {
    @NotEmpty(message = "Requerimento é obrigatório")
    private String requerimento;
    @NotEmpty(message = "Título é obrigatório")
    private String titulo;
    @NotEmpty(message = "Aluno é obrigatório")
    private int idAluno;
}
