package com.colegiado.sistemacolegiado.repositories;

import com.colegiado.sistemacolegiado.models.Assunto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssuntoRepositorio extends JpaRepository<Assunto, Integer> {
}
