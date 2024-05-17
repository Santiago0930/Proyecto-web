package co.edu.javeriana.proyecto_web.service;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.Tripulante;
import co.edu.javeriana.proyecto_web.repository.TripulanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TripulanteService {
    @Autowired
    private TripulanteRepository tripulanteRepository;

    @Transactional
    public List<Tripulante> listarTripulantes() {
        return tripulanteRepository.findAll();
    }

    @Transactional
    public Tripulante recuperarTripulante(Long id) {
        return tripulanteRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void guardarTripulante(Tripulante tripulante) {
        tripulanteRepository.save(tripulante);
    }

    @Transactional
    public List<Tripulante> buscarPorUsuario(String textoBusqueda) {
        return tripulanteRepository.findAllByUsuario(textoBusqueda);
    }

    @Transactional
    public void eliminartripulante(Long id) {
        tripulanteRepository.deleteById(id);
    }

}