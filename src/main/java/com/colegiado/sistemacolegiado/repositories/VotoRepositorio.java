package com.colegiado.sistemacolegiado.repositories;

import com.colegiado.sistemacolegiado.models.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

public interface VotoRepositorio extends JpaRepository<Voto, Integer> {
}
