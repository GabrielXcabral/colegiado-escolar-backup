package com.colegiado.sistemacolegiado.models;

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
    private int id;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private LocalDate dataRecepcao;
    @Column()
    private LocalDate dataDistribuicao;
    @Column()
    private LocalDate dataParecer;
    @Column()
    private byte[] parecer;
    @ManyToMany
    private ArrayList<Professor> professores;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Processo processo;
    @ManyToOne
    private Reuniao reuniao;



}
