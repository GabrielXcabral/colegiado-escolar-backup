package com.colegiado.sistemacolegiado.services;

import com.colegiado.sistemacolegiado.models.Assunto;
import com.colegiado.sistemacolegiado.models.Professor;
import com.colegiado.sistemacolegiado.models.dto.CriarAssuntoDTO;
import com.colegiado.sistemacolegiado.models.dto.UsuarioDTO;
import com.colegiado.sistemacolegiado.repositories.AssuntoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuntoService {
    final AssuntoRepositorio assuntoRepositorio;
    public AssuntoService(AssuntoRepositorio assuntoRepositorio){
        this.assuntoRepositorio = assuntoRepositorio;
    }
    public Assunto criarAssunto(CriarAssuntoDTO assunto){
        return this.assuntoRepositorio.save(new Assunto(assunto));
    }
    public List<Assunto> listarAssuntos(){
        return this.assuntoRepositorio.findAll();
    }
    public Assunto encontrarPorId(int id){

        return this.assuntoRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Assunto não localizado"));
    }
    public void deletarAssunto(Assunto assunto){
        this.assuntoRepositorio.delete(assunto);
    }

    public Assunto atualizarAssunto(Integer id, UsuarioDTO assuntoDTO) {
        Assunto assunto = encontrarPorId(id);
        assunto.setNome(assuntoDTO.getNome());
        return assuntoRepositorio.save(assunto);
    }
}


