package com.colegiado.sistemacolegiado.services;

import com.colegiado.sistemacolegiado.models.Assunto;
import com.colegiado.sistemacolegiado.models.Colegiado;
import com.colegiado.sistemacolegiado.models.Professor;
import com.colegiado.sistemacolegiado.repositories.AssuntoRepositorio;
import com.colegiado.sistemacolegiado.repositories.ColegiadoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ColegiadoService {
    final ColegiadoRepositorio colegiadoRepositorio;
    final ProfessorService professorService;

    public Colegiado criarColegiado(Colegiado colegiado){
        return this.colegiadoRepositorio.save(colegiado);
    }
    public List<Colegiado> listarColegiado(){
        return this.colegiadoRepositorio.findAll();
    }
    public Optional<Colegiado> encontrarPorId(int id){
        return this.colegiadoRepositorio.findById(id);

    }
    public void deletarColegiado(Colegiado colegiado){
        this.colegiadoRepositorio.delete(colegiado);
    }

    public Colegiado adicionarProfessor(int idColegiado, int idProfessor){
        Professor professor = professorService.encontrarPorId(idProfessor).orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        Colegiado colegiado = encontrarPorId(idColegiado).orElseThrow(() -> new RuntimeException("Colegiado não encotrado"));
        colegiado.getProfessores().add(professor);
        return this.colegiadoRepositorio.save(colegiado);

    }

}
