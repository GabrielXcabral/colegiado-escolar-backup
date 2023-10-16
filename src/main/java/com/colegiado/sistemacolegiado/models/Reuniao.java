package com.colegiado.sistemacolegiado.models;

import com.colegiado.sistemacolegiado.models.enums.StatusReuniao;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
public class Reuniao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private LocalDate dataReuniao;
    @Column (nullable = false)
    private StatusReuniao status;
    @Column ()
    private byte[] ata;
    @ManyToOne
    private Colegiado colegiado;
    @OneToMany(mappedBy = "reuniao")
    private ArrayList<Processo> processos;
}
