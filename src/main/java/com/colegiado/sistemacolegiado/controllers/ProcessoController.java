package com.colegiado.sistemacolegiado.controllers;

import com.colegiado.sistemacolegiado.models.dto.CriarProcessoDTO;
import com.colegiado.sistemacolegiado.models.Processo;
import com.colegiado.sistemacolegiado.models.dto.FiltrarProcessoDTO;
import com.colegiado.sistemacolegiado.models.dto.ProcessoDTO;
import com.colegiado.sistemacolegiado.services.ProcessoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/processo")
@AllArgsConstructor
public class ProcessoController {
    final ProcessoService processoService;

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{idAluno}")
    public ProcessoDTO criarProcesso(@PathVariable Integer idAluno, CriarProcessoDTO processo){
        processo.setIdAluno(idAluno);
        return new ProcessoDTO(processoService.criarProcesso(processo));
    }

    @GetMapping("/filtro/aluno/{idAluno}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ProcessoDTO> listarProcessosAluno(@PathVariable Integer idAluno, FiltrarProcessoDTO filtro){
        filtro.setIdAluno(idAluno);
        return processoService.listarProcessos(filtro).stream().map(ProcessoDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/filtro/professor/{idProfessor}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ProcessoDTO> listarProcessosProcesso(@PathVariable Integer idProfessor, FiltrarProcessoDTO filtro){
        filtro.setIdProfessor(idProfessor);
        return processoService.listarProcessos(filtro).stream().map(ProcessoDTO::new).collect(Collectors.toList());
    }


    @GetMapping("/filtro/coordenador")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ProcessoDTO> listarProcessosCoordenador( FiltrarProcessoDTO filtro){
        return processoService.listarProcessos(filtro).stream().map(ProcessoDTO::new).collect(Collectors.toList());
    }

    @PostMapping("atribuir/{idProcesso}/{idProfessor}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ProcessoDTO atribuirProcesso(@PathVariable Integer idProcesso,
                                        @PathVariable Integer idProfessor){
        return new ProcessoDTO(processoService.atribuirProcesso(idProcesso, idProfessor));
    }
}
