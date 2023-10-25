package com.colegiado.sistemacolegiado.controllers;

import com.colegiado.sistemacolegiado.models.Aluno;
import com.colegiado.sistemacolegiado.models.Colegiado;
import com.colegiado.sistemacolegiado.models.dto.AlunoDTO;
import com.colegiado.sistemacolegiado.models.dto.CriarColegiadoDTO;
import com.colegiado.sistemacolegiado.models.dto.UsuarioDTO;
import com.colegiado.sistemacolegiado.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/alunos")
public class AlunoController {

    final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ModelAndView criarAluno(ModelAndView modelAndView, @Valid UsuarioDTO aluno,  BindingResult bindingResult, RedirectAttributes attr) {

        if (alunoService.verificarTelefone(aluno.getFone())) {
            attr.addFlashAttribute("message", "Conflict: Telefone já existe no banco");
            attr.addFlashAttribute("error", "true");
            modelAndView.setViewName("redirect:/alunos/new");
        }

        if (alunoService.verificarMatricula(aluno.getMatricula())) {
            attr.addFlashAttribute("message", "Conflict: Matricula já existe no banco");
            attr.addFlashAttribute("error", "true");
            modelAndView.setViewName("redirect:/alunos/new");
        }

        if (alunoService.verificarLogin(aluno.getLogin())) {
            attr.addFlashAttribute("message", "Conflict: Login já existe no banco");
            attr.addFlashAttribute("error", "true");
            modelAndView.setViewName("redirect:/alunos/new");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("alunos/new");
        } else {
            alunoService.criarAluno(aluno);
            attr.addFlashAttribute("message", "Aluno cadastrado com sucesso!");
            attr.addFlashAttribute("error", "false");
            modelAndView.setViewName("redirect:/alunos");
        }

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAluno(@PathVariable(value = "id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.encontrarPorId(id));
    }

    @GetMapping("/new")
    public ModelAndView current(ModelAndView modelAndView, UsuarioDTO alunoDTO) {
        List<Aluno> alunos = alunoService.listarAlunos();

        modelAndView.setViewName("alunos/new");
        modelAndView.addObject("alunos", alunos);
        modelAndView.addObject("alunoDTO", alunoDTO);

        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAlunos(ModelAndView modelAndView) {
        List<Aluno> alunos = alunoService.listarAlunos();

        modelAndView.setViewName("alunos/index");
        modelAndView.addObject("alunos", alunos);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id, ModelAndView modelAndView, RedirectAttributes attr) {
        try {
            Aluno aluno = alunoService.encontrarPorId(id);

            var request = new AlunoDTO(aluno);

            modelAndView.setViewName("alunos/edit");
            modelAndView.addObject("alunoId", aluno.getId());
             modelAndView.addObject("aluno", request);

        } catch (Exception e) {
            attr.addFlashAttribute("message", "Error: "+e);
            attr.addFlashAttribute("error", "true");
            modelAndView.setViewName("redirect:/alunos");
        }

        return modelAndView;
    }

    @PostMapping("/{id}")
    public ModelAndView atualizarAluno(ModelAndView modelAndView, @PathVariable Integer id, @Valid UsuarioDTO aluno, BindingResult bindingResult, RedirectAttributes attr){

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("redirect:/alunos/{id}/edit");
        } else {

            attr.addFlashAttribute("message", "OK: Aluno editado com sucesso!");
            attr.addFlashAttribute("error", "false");
            alunoService.atualizarAluno(id, aluno);

            modelAndView.setViewName("redirect:/alunos");
        }

        return modelAndView;
    }


    @GetMapping("/{id}/delete")
    public ModelAndView deletarAluno(ModelAndView modelAndView, @PathVariable (value = "id") int id, RedirectAttributes attr){
        try {
            var alunoExistente = alunoService.encontrarPorId(id);
            alunoService.deletarAluno(alunoExistente);
            attr.addFlashAttribute("message", "OK: Aluno excluído com sucesso!");
            attr.addFlashAttribute("error", "false");
            modelAndView.setViewName("redirect:/alunos");
        } catch (Exception e) {
            attr.addFlashAttribute("message", "Error: "+e);
            attr.addFlashAttribute("error", "true");
            modelAndView.setViewName("redirect:/alunos");
        }

        return modelAndView;
    }
}

