package com.colegiado.sistemacolegiado.services;

import com.colegiado.sistemacolegiado.models.Aluno;
import com.colegiado.sistemacolegiado.repositories.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    final AlunoRepository alunoRepository;


    public AlunoService (AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public Aluno save (Aluno aluno){
        return  this.alunoRepository.save(aluno);
    }

    public Optional<Aluno> findById (int id){
        return alunoRepository.findById(id);
    }

    public List<Aluno> findAll (){
        return  alunoRepository.findAll();
    }

    @Transactional
    public void delete (Aluno aluno){
        alunoRepository.delete(aluno);
    }


    public boolean existsByfone(String fone){
        return alunoRepository.existsByfone(fone);
    }


    public boolean existsBymatricula(String matricula) {
        return  alunoRepository.existsBymatricula((matricula));
    }

    public  boolean existsBylogin (String login){
        return alunoRepository.existsBylogin(login);
    }




}
