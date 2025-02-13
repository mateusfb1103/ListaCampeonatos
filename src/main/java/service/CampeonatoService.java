package com.example.campeonato.service;

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.repository.CampeonatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CampeonatoService {
    
    private final CampeonatoRepository campeonatoRepository;

    public List<Campeonato> listarCampeonatos() {
        return campeonatoRepository.findAll();
    }

    public Optional<Campeonato> buscarPorId(Long id) {
        return campeonatoRepository.findById(id);
    }

    public Campeonato salvar(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public void deletar(Long id) {
        campeonatoRepository.deleteById(id);
    }
}
