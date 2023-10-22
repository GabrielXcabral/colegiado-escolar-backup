package com.colegiado.sistemacolegiado.repositories;

import com.colegiado.sistemacolegiado.models.Aluno;
import com.colegiado.sistemacolegiado.models.Assunto;
import com.colegiado.sistemacolegiado.models.Processo;
import com.colegiado.sistemacolegiado.models.Professor;
import com.colegiado.sistemacolegiado.models.enums.StatusProcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessoRepositorio extends JpaRepository<Processo, Integer> {
    List<Processo> findByStatusAndAssuntoAndAlunoOrderByDataRecepcao(StatusProcesso status, Assunto assunto, Aluno aluno);

    List<Processo> findByStatusAndAssuntoAndProfessorOrderByDataRecepcao(StatusProcesso status, Assunto assunto, Professor professor);

    List<Processo> findAllByOrderByDataRecepcao();

    List<Processo> findAllByAlunoAndProfessorAndStatusOrderByDataRecepcao(Aluno aluno, Professor professor, StatusProcesso status);
}
