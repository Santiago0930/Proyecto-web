package co.edu.javeriana.proyecto_web.service;

import java.util.*;

import co.edu.javeriana.proyecto_web.model.Estrella;
import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import co.edu.javeriana.proyecto_web.repository.EstrellaRepository;
import co.edu.javeriana.proyecto_web.repository.NaveComRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EstrellaService {
    @Autowired
    private EstrellaRepository estrellaRepository;

    @Autowired
    private NaveComRepository naveRepository;

    @Transactional
    public List<Estrella> listarEstrellas(Long id) {
        NaveComerciante nave = naveRepository.findById(id).orElseThrow();
        List<Estrella> estrellas = estrellaRepository.findAll();
        PriorityQueue<Estrella> queue = new PriorityQueue<>(11, Comparator.comparingDouble(e -> calcularDistancia(e, nave.getX(), nave.getY(), nave.getZ())));

        estrellas.forEach(estrella -> {
            queue.add(estrella);
            if (queue.size() > 10) {
                queue.poll();
            }
        });

        List<Estrella> estrellasCercanas = new ArrayList<>();
        while (!queue.isEmpty()) {
            estrellasCercanas.add(queue.poll());
        }
        Collections.reverse(estrellasCercanas);
        return estrellasCercanas;
    }

    private double calcularDistancia(Estrella estrella, double x, double y, double z) {
        return Math.sqrt(Math.pow(estrella.getX() - x, 2) + Math.pow(estrella.getY() - y, 2) + Math.pow(estrella.getZ() - z, 2));
    }
    
}