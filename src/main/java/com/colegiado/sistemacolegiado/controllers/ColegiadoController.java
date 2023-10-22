package com.colegiado.sistemacolegiado.controllers;

import com.colegiado.sistemacolegiado.models.Colegiado;
import com.colegiado.sistemacolegiado.models.dto.ColegiadoDTO;
import com.colegiado.sistemacolegiado.models.dto.CriarColegiadoDTO;
import com.colegiado.sistemacolegiado.services.ColegiadoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/colegiado")
@AllArgsConstructor
public class ColegiadoController {

    private final ColegiadoService colegiadoService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Colegiado criarColegiado(@RequestBody @Valid CriarColegiadoDTO colegiadoDTO){
        return colegiadoService.criarColegiado(colegiadoDTO);
    }

    @PatchMapping("/professor/{idColegiado}/{idProfessor}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ColegiadoDTO adicionaProfessor(@PathVariable Integer idColegiado,
                                          @PathVariable Integer idProfessor){
        return new ColegiadoDTO(colegiadoService.adicionarProfessor(idColegiado, idProfessor));
    }

    @DeleteMapping("/professor/{idColegiado}/{idProfessor}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ColegiadoDTO removeProfessor(@PathVariable Integer idColegiado,
                                     @PathVariable Integer idProfessor){
        return new ColegiadoDTO(colegiadoService.removerProfessor(idColegiado, idProfessor));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarColegiado(@PathVariable Integer id){
        colegiadoService.deletarColegiado(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Colegiado buscaColegiado(@PathVariable Integer id){
        return colegiadoService.encontrarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Colegiado atualizaColegiado(@PathVariable Integer id,
                                    @RequestBody @Valid CriarColegiadoDTO colegiadoDTO){
        return colegiadoService.atualizarColegiado(id, colegiadoDTO);
    }
}
