package com.colegiado.sistemacolegiado.services;

import com.colegiado.sistemacolegiado.models.Aluno;
import com.colegiado.sistemacolegiado.repositories.AlunoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    final AlunoRepositorio alunoRepository;


    public AlunoService (AlunoRepositorio alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public Aluno criarAluno(Aluno aluno){
        return  this.alunoRepository.save(aluno);
    }

    public Optional<Aluno> encontrarPorId(int id){
        return alunoRepository.findById(id);
    }

    public List<Aluno> listarAlunos(){
        return  alunoRepository.findAll();
    }

    @Transactional
    public void deletarAluno(Aluno aluno){
        alunoRepository.delete(aluno);
    }


    public boolean verificarTelefone(String fone){
        return alunoRepository.existsByfone(fone);
    }


    public boolean verificarMatricula(String matricula) {
        return  alunoRepository.existsBymatricula((matricula));
    }

    public  boolean verificarLogin(String login){
        return alunoRepository.existsBylogin(login);
    }




}
