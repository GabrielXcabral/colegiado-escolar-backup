package com.colegiado.sistemacolegiado.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String numero;
    @Column (nullable = false)
    private LocalDate dataRecepcao;
    @Column ()
    private LocalDate dataDistribuicao;
    @Column ()
    private LocalDate dataParecer;
    private byte[] parecer;


}
