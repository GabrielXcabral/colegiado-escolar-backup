package com.colegiado.sistemacolegiado.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Professor extends Usuario{

    private boolean coordenador;
    @ManyToOne
    private Colegiado colegiado;
    @ManyToMany
    private ArrayList<Processo> processos;

    public Professor(int id, String nome, String fone, String matricula, String login, String senha, boolean coordenador){
        super(id, nome, fone, matricula, login, senha);
        this.coordenador = coordenador;
    }

}
