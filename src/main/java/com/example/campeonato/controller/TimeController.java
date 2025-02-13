package com.example.campeonato.controller;

import com.example.campeonato.model.Time;
import com.example.campeonato.service.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
@RequiredArgsConstructor
public class TimeController {

    private final TimeService timeService;

    @GetMapping
    public List<Time> listarTodos() {
        return timeService.listarTimes();
    }

    @PostMapping
    public Time criar(@RequestBody Time time) {
        return timeService.salvar(time);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        timeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
