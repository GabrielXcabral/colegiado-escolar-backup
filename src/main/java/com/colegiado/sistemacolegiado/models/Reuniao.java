package com.colegiado.sistemacolegiado.models;

import com.colegiado.sistemacolegiado.models.enums.StatusReuniao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
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
    private List<Processo> processos;
}
