package com.kaianluciano.movie.modell;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_movie")
@Getter @Setter
public class MovieModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 85)
    private String titulo;

    @Column(nullable = false, unique = false, length = 25)
    private String diretor;

    @Column(nullable = false, unique = false, length = 10)
    private Date anoLancamento;

    @Column(nullable = false, unique = true)
    private String sinopse;

    @Column(nullable = false, unique = false, length = 3)
    private Double media;

}
