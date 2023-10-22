package com.colegiado.sistemacolegiado.controllers;

import com.colegiado.sistemacolegiado.models.Assunto;
import com.colegiado.sistemacolegiado.models.dto.CriarAssuntoDTO;
import com.colegiado.sistemacolegiado.models.dto.UsuarioDTO;
import com.colegiado.sistemacolegiado.services.AssuntoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/assunto")
public class AssuntoController {
    private final AssuntoService assuntoService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Assunto criarAssunto(@RequestBody CriarAssuntoDTO assuntoDTO){
        return assuntoService.criarAssunto(assuntoDTO);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Assunto atualizarAssunto(@PathVariable Integer id,
                                    @RequestBody @Valid UsuarioDTO assuntoDTO){
        return assuntoService.atualizarAssunto(id, assuntoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAssunto(@PathVariable (value = "id") int id){
        var assuntoExistente = assuntoService.encontrarPorId(id);
        assuntoService.deletarAssunto(assuntoExistente);
        return ResponseEntity.status(HttpStatus.OK).body("OK: Assunto excluído com sucesso!");
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Assunto buscaAssunto(@PathVariable Integer id){
        return assuntoService.encontrarPorId(id);
    }


}
