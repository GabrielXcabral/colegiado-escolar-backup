package com.colegiado.sistemacolegiado.services;


import com.colegiado.sistemacolegiado.models.Processo;
import com.colegiado.sistemacolegiado.models.Professor;
import com.colegiado.sistemacolegiado.models.Voto.Voto;
import com.colegiado.sistemacolegiado.models.Voto.VotoId;
import com.colegiado.sistemacolegiado.models.enums.TipoDecisao;
import com.colegiado.sistemacolegiado.models.enums.TipoVoto;
import com.colegiado.sistemacolegiado.repositories.ProcessoRepositorio;
import com.colegiado.sistemacolegiado.repositories.ProfessorRepositorio;
import com.colegiado.sistemacolegiado.repositories.VotoRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProcessoService {
    final ProcessoRepositorio processoRepositorio;
    final ProfessorRepositorio professorRepositorio;
    final VotoRepositorio votoRepositorio;

    public Processo criarProcesso(Processo processo){
        if (processo.getId() == null || !this.processoRepositorio.existsById(processo.getId())) {
            return this.processoRepositorio.save(processo);
        } else {
            throw new RuntimeException("O processo já existe");
        }
    }

    public Optional<Processo> encontrarPorId(int id){
        return this.processoRepositorio.findById(id);
    }

    public List<Processo> listarProcessos(){
        return this.processoRepositorio.findAll();
    }

    public void deletarProcesso(Processo processo){
        if (processo.getId() != null && this.processoRepositorio.existsById(processo.getId())) {
            this.processoRepositorio.delete(processo);
        } else {
            throw new RuntimeException("O processo não existe");
        }
    }

    public Processo mudarDecisao(int id, TipoDecisao novaDecisao){
        Optional<Processo> processoOptional = this.processoRepositorio.findById(id);
        if (processoOptional.isPresent()) {
            Processo processo = processoOptional.get();
            processo.setParecer(novaDecisao);
            return this.processoRepositorio.save(processo);
        } else {
            throw new RuntimeException("Processo não encontrado");
        }
    };

    public void votar(int idProfessor, int idProcesso, TipoVoto voto){
        Professor professor = this.professorRepositorio.findById(idProfessor)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        Processo processo = this.processoRepositorio.findById(idProcesso)
                .orElseThrow(() -> new RuntimeException("Processo não encontrado"));
        VotoId votoId = new VotoId(idProfessor, idProcesso);
        Voto votoFinal = new Voto(votoId, professor, processo, voto);
        this.votoRepositorio.save(votoFinal);
    }
}
