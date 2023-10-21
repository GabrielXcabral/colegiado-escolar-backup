package com.colegiado.sistemacolegiado.repositories;

import com.colegiado.sistemacolegiado.models.Reuniao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReuniaoRepositorio extends JpaRepository<Reuniao, Integer> {
}
