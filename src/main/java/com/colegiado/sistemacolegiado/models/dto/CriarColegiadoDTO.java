package com.colegiado.sistemacolegiado.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CriarColegiadoDTO {

    private String descricao;
    private String portaria;
    private String curso;
}
