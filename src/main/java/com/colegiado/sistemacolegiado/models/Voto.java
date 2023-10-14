package com.colegiado.sistemacolegiado.models;

import com.colegiado.sistemacolegiado.models.enums.TipoVoto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Voto {

    @EmbeddedId
    private VotoId id;

    @ManyToOne
    @MapsId("id_professor")
    @JoinColumn(name="id_professor")
    private Professor professor;
    @ManyToOne
    @MapsId("id_processo")
    @JoinColumn(name= "id_processo")
    private Processo processo;
    private TipoVoto voto;
}

@Embeddable
class VotoId implements Serializable {
    @Column(name = "id_professor")
    private int idProfessor;
    @Column(name ="id_processo")
    private int idProcesso;

}
