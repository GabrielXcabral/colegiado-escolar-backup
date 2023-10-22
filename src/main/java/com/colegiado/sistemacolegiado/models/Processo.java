package com.colegiado.sistemacolegiado.models;

import com.colegiado.sistemacolegiado.models.dto.CriarProcessoDTO;
import com.colegiado.sistemacolegiado.models.enums.TipoDecisao;
import com.colegiado.sistemacolegiado.models.enums.StatusProcesso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private LocalDate dataRecepcao;
    private LocalDate dataDistribuicao;
    private LocalDate dataParecer;
    private TipoDecisao parecer;
    @ManyToOne
    private Professor professor;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Reuniao reuniao;
    private String assunto;
    private String requerimento;
    private StatusProcesso status;

    public Processo(CriarProcessoDTO processoDTO, Aluno aluno) {
        this.aluno = aluno;
        this.assunto = processoDTO.getTitulo();
        this.requerimento = processoDTO.getRequerimento();
        this.status = StatusProcesso.CRIADO;
    }
}
