package com.colegiado.sistemacolegiado.repositories;

import com.colegiado.sistemacolegiado.models.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepositorio extends JpaRepository<Processo, Integer> {
}
