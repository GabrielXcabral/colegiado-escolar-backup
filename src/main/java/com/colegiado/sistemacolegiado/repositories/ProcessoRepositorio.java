package com.colegiado.sistemacolegiado.repositories;

import com.colegiado.sistemacolegiado.models.Aluno;
import com.colegiado.sistemacolegiado.models.Assunto;
import com.colegiado.sistemacolegiado.models.Processo;
import com.colegiado.sistemacolegiado.models.Professor;
import com.colegiado.sistemacolegiado.models.enums.StatusProcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessoRepositorio extends JpaRepository<Processo, Integer> {
    @Query("select processo from Processo processo where processo.aluno = :aluno " +
            "and (:status is null or processo.status = :status) " +
            "and (:assunto is null or processo.assunto = :assunto)")
    List<Processo> findByStatusAndAssuntoAndAlunoOrderByDataRecepcao(StatusProcesso status, Assunto assunto, Aluno aluno);

    @Query("select processo from Processo processo where processo.professor = :professor " +
            "and (:status is null or processo.status = :status) " +
            "and (:assunto is null or processo.assunto = :assunto)")
    List<Processo> findByStatusAndAssuntoAndProfessorOrderByDataRecepcao(StatusProcesso status, Assunto assunto, Professor professor);

    List<Processo> findAllByOrderByDataRecepcao();

    @Query("select processo from Processo processo where 1=1 " +
            "and (:professor is null or processo.professor = :professor) " +
            "and (:aluno is null or processo.aluno = :aluno) " +
            "and (:status is null or processo.status = :status)")
    List<Processo> findAllByAlunoAndProfessorAndStatusOrderByDataRecepcao(Aluno aluno, Professor professor, StatusProcesso status);
}
