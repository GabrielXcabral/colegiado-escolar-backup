package com.colegiado.sistemacolegiado.models;

import com.colegiado.sistemacolegiado.models.enums.TipoVoto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private TipoVoto voto;
}
