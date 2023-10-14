package com.colegiado.sistemacolegiado.repositories;

import com.colegiado.sistemacolegiado.models.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepositorio extends JpaRepository<Processo, Integer> {
}
