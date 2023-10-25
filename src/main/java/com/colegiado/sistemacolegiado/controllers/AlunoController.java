package com.colegiado.sistemacolegiado.controllers;

import com.colegiado.sistemacolegiado.models.Aluno;
import com.colegiado.sistemacolegiado.models.Colegiado;
import com.colegiado.sistemacolegiado.models.dto.CriarColegiadoDTO;
import com.colegiado.sistemacolegiado.models.dto.UsuarioDTO;
import com.colegiado.sistemacolegiado.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/aluno")
public class AlunoController {

    final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Object> criarAluno(@RequestBody @Valid UsuarioDTO aluno) {
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
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.encontrarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.listarAlunos());
    }

    @PostMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Aluno atualizarAluno(@PathVariable Integer id,
                                       @RequestBody @Valid UsuarioDTO alunoDTO){
        return alunoService.atualizarAluno(id, alunoDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAluno(@PathVariable (value = "id") int id){
        var alunoExistente = alunoService.encontrarPorId(id);
        alunoService.deletarAluno(alunoExistente);
        return ResponseEntity.status(HttpStatus.OK).body("OK: Aluno exluido com sucesso!");

    }
}

