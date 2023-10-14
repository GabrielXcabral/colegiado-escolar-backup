package com.colegiado.sistemacolegiado.models;

public class Professor extends Usuario{
    private boolean coordenador;

    public Professor(){

    }

    public Professor(int id, String nome, String fone, String matricula, String login, String senha, boolean coordenador){
        super();
        this.coordenador = coordenador;
    }

}
