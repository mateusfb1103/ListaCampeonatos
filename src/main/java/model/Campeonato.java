package com.example.campeonato.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private List<TimeCampeonato> times;
}
