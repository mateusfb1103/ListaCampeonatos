package com.example.campeonato.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeCampeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

    private int pontos;
}
