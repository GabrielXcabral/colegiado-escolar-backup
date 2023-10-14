package com.colegiado.sistemacolegiado.models;

public class Aluno extends Usuario{

    public Aluno(){
    }
    public Aluno(int id, String nome, String fone, String matricula, String login, String senha){
        super(id, nome, fone, matricula, login, senha);
    }

}
