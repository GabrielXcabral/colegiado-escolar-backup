package com.colegiado.sistemacolegiado.models;

import com.colegiado.sistemacolegiado.models.dto.CriarColegiadoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.cglib.core.Local;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Colegiado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private LocalDate dataInicio;
    private LocalDate dataFim;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String portaria;
    @Column(nullable = false)
    private String curso;
    @OneToMany(mappedBy = "colegiado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Professor> professores = new ArrayList<>();

    public Colegiado(CriarColegiadoDTO colegiadoDTO) {
        this.dataInicio = LocalDate.now();
        this.descricao = colegiadoDTO.getDescricao();
        this.portaria = colegiadoDTO.getPortaria();
        this.curso = colegiadoDTO.getCurso();
    }
}
