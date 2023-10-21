package com.colegiado.sistemacolegiado.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;

@Entity
public class Aluno extends Usuario{

    public Aluno(){
    }
    public Aluno(int id, String nome, String fone, String matricula, String login, String senha){
        super(id, nome, fone, matricula, login, senha);
    }
    @OneToMany(mappedBy = "aluno")
    private ArrayList<Processo> processos;

}
