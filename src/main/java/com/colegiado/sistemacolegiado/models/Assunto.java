package com.colegiado.sistemacolegiado.models;

import jakarta.persistence.*;

@Entity
public class Assunto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column
    String nome;
}
