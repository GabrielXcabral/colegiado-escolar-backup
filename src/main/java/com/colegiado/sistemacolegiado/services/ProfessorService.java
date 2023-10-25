package com.colegiado.sistemacolegiado.services;

import com.colegiado.sistemacolegiado.models.Aluno;
import com.colegiado.sistemacolegiado.models.Professor;
import com.colegiado.sistemacolegiado.models.dto.ProfessorDTO;
import com.colegiado.sistemacolegiado.models.dto.UsuarioDTO;
import com.colegiado.sistemacolegiado.repositories.ProfessorRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfessorService {
    final ProfessorRepositorio professorRepositorio;

    public Professor criarProfessor(UsuarioDTO professorDTO){
        return  this.professorRepositorio.save(new Professor(professorDTO));
    }

    public Professor encontrarPorId(int id){
        return professorRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Professor não encontrado"));
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

    public Professor atualizarProfessor(Integer id, UsuarioDTO professorDTO) {
        Professor professor = encontrarPorId(id);
        professor.setNome(professorDTO.getNome());
        professor.setFone(professorDTO.getFone());
        professor.setMatricula(professorDTO.getMatricula());
        professor.setLogin(professorDTO.getLogin());
        professor.setSenha(professorDTO.getSenha());
        professor.setCoordenador(professorDTO.getCoordenador());
        return professorRepositorio.save(professor);
    }
}
