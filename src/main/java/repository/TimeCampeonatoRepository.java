package com.example.campeonato.repository;

import com.example.campeonato.model.TimeCampeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeCampeonatoRepository extends JpaRepository<TimeCampeonato, Long> {
    List<TimeCampeonato> findByCampeonatoIdOrderByPontosDesc(Long campeonatoId);
}
