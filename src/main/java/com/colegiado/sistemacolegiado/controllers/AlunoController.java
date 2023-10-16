package com.colegiado.sistemacolegiado.controllers;

import com.colegiado.sistemacolegiado.models.Aluno;
import com.colegiado.sistemacolegiado.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/controller-colegiado")
public class AlunoController {

    final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Object> criarAluno(@RequestBody @Valid Aluno aluno) {
        if (alunoService.verificarTelefone(aluno.getFone())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Telefone já existe no banco");
        }

        if (alunoService.verificarMatricula(aluno.getMatricula())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Matricula já existe no banco");
        }

        if (alunoService.verificarLogin(aluno.getLogin())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Login já existe no banco");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.criarAluno(aluno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAluno(@PathVariable(value = "id") int id) {
        Optional<Aluno> verificarAluno = alunoService.encontrarPorId(id);

        if (!verificarAluno.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conflict: Id invalido");
        }
        return ResponseEntity.status(HttpStatus.OK).body(verificarAluno.get());
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.listarAlunos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAluno (@PathVariable (value = "id") int id, @RequestBody @Valid Aluno aluno){
        Optional<Aluno> verificarAluno = alunoService.encontrarPorId(id);

        if(!verificarAluno.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found:  Id invalido");
        }

        Aluno alunoExistente = verificarAluno.get();
        alunoExistente.setNome(aluno.getNome());
        alunoExistente.setFone(aluno.getFone());
        alunoExistente.setMatricula(aluno.getMatricula());
        alunoExistente.setLogin(aluno.getLogin());
        alunoExistente.setSenha(aluno.getSenha());

        return ResponseEntity.status(HttpStatus.OK).body(alunoService.criarAluno(alunoExistente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAluno(@PathVariable (value = "id") int id){
        Optional<Aluno> verificarAluno = alunoService.encontrarPorId(id);

        if(!verificarAluno.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found: Id invalido");
        }

        var alunoExistente = verificarAluno.get();
        alunoService.deletarAluno(alunoExistente);
        return ResponseEntity.status(HttpStatus.OK).body("OK: Aluno exluido com sucesso!");

    }
}

