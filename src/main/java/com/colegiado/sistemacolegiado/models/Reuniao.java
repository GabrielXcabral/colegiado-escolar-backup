package com.colegiado.sistemacolegiado.models;

import com.colegiado.sistemacolegiado.models.enums.StatusReuniao;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

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
}
