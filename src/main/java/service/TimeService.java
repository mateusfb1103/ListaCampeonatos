package com.example.campeonato.service;

import com.example.campeonato.model.Time;
import com.example.campeonato.repository.TimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeService {

    private final TimeRepository timeRepository;

    public List<Time> listarTimes() {
        return timeRepository.findAll();
    }

    public Time salvar(Time time) {
        return timeRepository.save(time);
    }

    public void deletar(Long id) {
        timeRepository.deleteById(id);
    }
}
