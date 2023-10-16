package com.colegiado.sistemacolegiado.services;

import com.colegiado.sistemacolegiado.models.Assunto;
import com.colegiado.sistemacolegiado.models.Professor;
import com.colegiado.sistemacolegiado.repositories.AssuntoRepositorio;

import java.util.List;
import java.util.Optional;

public class AssuntoService {
    final AssuntoRepositorio assuntoRepositorio;
    public AssuntoService(AssuntoRepositorio assuntoRepositorio){
        this.assuntoRepositorio = assuntoRepositorio;
    }
    public Assunto criarAssunto(Assunto assunto){
        return this.assuntoRepositorio.save(assunto);
    }
    public List<Assunto> listarAssuntos(){
        return this.assuntoRepositorio.findAll();
    }
    public Optional<Assunto> encontrarPorId(int id){
        return this.assuntoRepositorio.findById(id);

    }
    public void deletarAssunto(Assunto assunto){
        this.assuntoRepositorio.delete(assunto);
    }

}


