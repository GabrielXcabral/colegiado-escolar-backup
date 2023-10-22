package com.colegiado.sistemacolegiado.controllers;


import com.colegiado.sistemacolegiado.models.Aluno;
import com.colegiado.sistemacolegiado.models.Colegiado;
import com.colegiado.sistemacolegiado.models.Professor;
import com.colegiado.sistemacolegiado.models.dto.UsuarioDTO;
import com.colegiado.sistemacolegiado.services.AlunoService;
import com.colegiado.sistemacolegiado.services.ProfessorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/professor")
@AllArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @PostMapping("/professor")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Professor criarProfessor(@RequestBody @Valid UsuarioDTO usuarioDTO){
        return professorService.criarProfessor(usuarioDTO);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Professor atualizarProfessor(@PathVariable Integer id,
                                @RequestBody @Valid UsuarioDTO professorDTO){
        return professorService.atualizarProfessor(id, professorDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAluno(@PathVariable (value = "id") int id){
        var professorExistente = professorService.encontrarPorId(id);
        professorService.deletarProfessores(professorExistente);
        return ResponseEntity.status(HttpStatus.OK).body("OK: professor exluido com sucesso!");

    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Professor buscaProfessor(@PathVariable Integer id){
        return professorService.encontrarPorId(id);
    }
}
