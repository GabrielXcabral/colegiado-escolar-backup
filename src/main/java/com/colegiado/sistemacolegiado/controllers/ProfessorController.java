package com.colegiado.sistemacolegiado.controllers;


import com.colegiado.sistemacolegiado.models.Aluno;
import com.colegiado.sistemacolegiado.models.Colegiado;
import com.colegiado.sistemacolegiado.models.Professor;
import com.colegiado.sistemacolegiado.models.dto.AlunoDTO;
import com.colegiado.sistemacolegiado.models.dto.ProfessorDTO;
import com.colegiado.sistemacolegiado.models.dto.UsuarioDTO;
import com.colegiado.sistemacolegiado.services.AlunoService;
import com.colegiado.sistemacolegiado.services.ProfessorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/professores")
@AllArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping
    public ModelAndView getAlunos(ModelAndView modelAndView) {
        List<Professor> professores = professorService.listarProfessores();

        modelAndView.setViewName("professores/index");
        modelAndView.addObject("professores", professores);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView current(ModelAndView modelAndView, UsuarioDTO professorDTO) {

        modelAndView.setViewName("professores/new");
        modelAndView.addObject("professorDTO", professorDTO);

        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView deletarProfessor(ModelAndView modelAndView, @PathVariable (value = "id") int id, RedirectAttributes attr){
        try {
            var professorExistente = professorService.encontrarPorId(id);
            professorService.deletarProfessores(professorExistente);
            attr.addFlashAttribute("message", "OK: Professor excluído com sucesso!");
            attr.addFlashAttribute("error", "false");
            modelAndView.setViewName("redirect:/professores");
        } catch (Exception e) {
            attr.addFlashAttribute("message", "Error: "+e);
            attr.addFlashAttribute("error", "true");
            modelAndView.setViewName("redirect:/professores");
        }

        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id, ModelAndView modelAndView, RedirectAttributes attr) {
        try {
            Professor professor = professorService.encontrarPorId(id);

            var request = new ProfessorDTO(professor);

            modelAndView.setViewName("professores/edit");
            modelAndView.addObject("professorId", professor.getId());
            modelAndView.addObject("professor", request);

        } catch (Exception e) {
            attr.addFlashAttribute("message", "Error: "+e);
            attr.addFlashAttribute("error", "true");
            modelAndView.setViewName("redirect:/professores");
        }

        return modelAndView;
    }

    @PostMapping
    public ModelAndView criarProfessor(ModelAndView modelAndView, @Valid UsuarioDTO professor, BindingResult bindingResult, RedirectAttributes attr){
        if (professorService.verificarTelefone(professor.getFone())) {
            attr.addFlashAttribute("message", "Conflict: Telefone já existe no banco");
            attr.addFlashAttribute("error", "true");
            modelAndView.setViewName("redirect:/professores/new");
        }

        if (professorService.verificarMatricula(professor.getMatricula())) {
            attr.addFlashAttribute("message", "Conflict: Matricula já existe no banco");
            attr.addFlashAttribute("error", "true");
            modelAndView.setViewName("redirect:/professores/new");
        }

        if (professorService.verificarLogin(professor.getLogin())) {
            attr.addFlashAttribute("message", "Conflict: Login já existe no banco");
            attr.addFlashAttribute("error", "true");
            modelAndView.setViewName("redirect:/professores/new");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("professores/new");
        } else {
            professorService.criarProfessor(professor);
            attr.addFlashAttribute("message", "Professor cadastrado com sucesso!");
            attr.addFlashAttribute("error", "false");
            modelAndView.setViewName("redirect:/professores");
        }

        return modelAndView;
    }

    @PostMapping("/{id}")
    public ModelAndView atualizarProfessor(ModelAndView modelAndView, @PathVariable Integer id, @Valid UsuarioDTO professor, BindingResult bindingResult, RedirectAttributes attr){

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("redirect:/professores/{id}/edit");
        } else {

            attr.addFlashAttribute("message", "OK: Professor editado com sucesso!");
            attr.addFlashAttribute("error", "false");
            professorService.atualizarProfessor(id, professor);

            modelAndView.setViewName("redirect:/professores");
        }

        return modelAndView;
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Professor buscaProfessor(@PathVariable Integer id){
        return professorService.encontrarPorId(id);
    }
}
