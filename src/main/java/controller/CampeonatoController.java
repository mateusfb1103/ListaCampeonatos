package com.example.campeonato.controller;

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.service.CampeonatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campeonatos")
@RequiredArgsConstructor
public class CampeonatoController {

    private final CampeonatoService campeonatoService;

    @GetMapping
    public List<Campeonato> listarTodos() {
        return campeonatoService.listarCampeonatos();
    }

    @PostMapping
    public Campeonato criar(@RequestBody Campeonato campeonato) {
        return campeonatoService.salvar(campeonato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        campeonatoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
