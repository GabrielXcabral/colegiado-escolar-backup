package com.colegiado.sistemacolegiado.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Assunto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String nome;
}
