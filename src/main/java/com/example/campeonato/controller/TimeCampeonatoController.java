package com.example.campeonato.controller;

import com.example.campeonato.model.TimeCampeonato;
import com.example.campeonato.service.TimeCampeonatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times-campeonato")
@RequiredArgsConstructor
public class TimeCampeonatoController {

    private final TimeCampeonatoService timeCampeonatoService;

    @PostMapping
    public TimeCampeonato adicionarTimeAoCampeonato(@RequestParam Long timeId, @RequestParam Long campeonatoId) {
        return timeCampeonatoService.adicionarTimeAoCampeonato(timeId, campeonatoId);
    }

    @PostMapping("/{id}/pontuar")
    public ResponseEntity<TimeCampeonato> adicionarPontos(@PathVariable Long id, @RequestParam int pontos) {
        return ResponseEntity.ok(timeCampeonatoService.adicionarPontos(id, pontos));
    }

    @GetMapping("/{campeonatoId}/classificacao")
    public List<TimeCampeonato> obterClassificacao(@PathVariable Long campeonatoId) {
        return timeCampeonatoService.obterClassificacao(campeonatoId);
    }
}
