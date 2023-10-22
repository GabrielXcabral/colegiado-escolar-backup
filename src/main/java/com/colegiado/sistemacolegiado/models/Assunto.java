package com.colegiado.sistemacolegiado.models;

import com.colegiado.sistemacolegiado.models.dto.CriarAssuntoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assunto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String nome;

    public Assunto(CriarAssuntoDTO assunto) {
        this.nome = assunto.getNome();
    }
}
