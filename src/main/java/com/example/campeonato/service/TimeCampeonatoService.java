package com.example.campeonato.service;

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.model.Time;
import com.example.campeonato.model.TimeCampeonato;
import com.example.campeonato.repository.CampeonatoRepository;
import com.example.campeonato.repository.TimeCampeonatoRepository;
import com.example.campeonato.repository.TimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeCampeonatoService {

    private final TimeRepository timeRepository;
    private final CampeonatoRepository campeonatoRepository;
    private final TimeCampeonatoRepository timeCampeonatoRepository;

    public TimeCampeonato adicionarTimeAoCampeonato(Long timeId, Long campeonatoId) {
        Time time = timeRepository.findById(timeId).orElseThrow(() -> new RuntimeException("Time não encontrado"));
        Campeonato campeonato = campeonatoRepository.findById(campeonatoId).orElseThrow(() -> new RuntimeException("Campeonato não encontrado"));

        TimeCampeonato timeCampeonato = new TimeCampeonato();
        timeCampeonato.setTime(time);
        timeCampeonato.setCampeonato(campeonato);
        timeCampeonato.setPontos(0); // Começa com 0 pontos

        return timeCampeonatoRepository.save(timeCampeonato);
    }

    public TimeCampeonato adicionarPontos(Long id, int pontos) {
        TimeCampeonato timeCampeonato = timeCampeonatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
        timeCampeonato.setPontos(timeCampeonato.getPontos() + pontos);
        return timeCampeonatoRepository.save(timeCampeonato);
    }

    public List<TimeCampeonato> obterClassificacao(Long campeonatoId) {
        return timeCampeonatoRepository.findByCampeonatoIdOrderByPontosDesc(campeonatoId);
    }
}
