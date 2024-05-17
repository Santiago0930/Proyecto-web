package co.edu.javeriana.proyecto_web.service;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.Planeta;
import co.edu.javeriana.proyecto_web.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PlanetaService {
    @Autowired
    private PlanetaRepository planetaRepository;

    @Transactional
    public List<Planeta> listarPlanetas(Long id) {
        return planetaRepository.obtenerPlanetas(id);
    }

    @Transactional
    public Planeta recuperarPlaneta(Long id) {
        return planetaRepository.obtenerPlaneta(id);
    }
    
}