package com.colegiado.sistemacolegiado.services;

import com.colegiado.sistemacolegiado.models.Aluno;
import com.colegiado.sistemacolegiado.models.Professor;
import com.colegiado.sistemacolegiado.models.enums.TipoVoto;
import com.colegiado.sistemacolegiado.repositories.ProfessorRepositorio;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorService {
    final ProfessorRepositorio professorRepositorio;

    public Professor criarProfessor(Professor professor){
        return  this.professorRepositorio.save(professor);
    }

    public Optional<Professor> encontrarPorId(int id){
        return professorRepositorio.findById(id);
    }

    public List<Professor> listarProfessores(){
        return professorRepositorio.findAll();
    }

    public void deletarProfessores(Professor professor){
        professorRepositorio.delete(professor);
    }

    public boolean verificarTelefone(String fone){
        return professorRepositorio.existsByfone(fone);
    }
    public boolean verificarMatricula(String matricula) {
        return  professorRepositorio.existsBymatricula((matricula));
    }

    public  boolean verificarLogin(String login){
        return professorRepositorio.existsBylogin(login);
    }

}
