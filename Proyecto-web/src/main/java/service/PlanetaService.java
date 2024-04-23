package co.edu.javeriana.proyecto_web.service;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.Planeta;
import co.edu.javeriana.proyecto_web.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetaService {
    @Autowired
    private PlanetaRepository planetaRepository;

    public List<Planeta> listarPlanetas(Long id) {
        return planetaRepository.obtenerPlanetas(id);
    }

    public Planeta recuperarPlaneta(Long id) {
        return planetaRepository.obtenerPlaneta(id);
    }

    /*public Planeta recuperarPlaneta(Long id) {
        return planetaRepository.findById(id).orElseThrow();
    }

    public void guardarPlaneta(Planeta planeta) {
        planetaRepository.save(planeta);
    }

    public List<Planeta> buscarPorNombre(String textoBusqueda) {
        return planetaRepository.findAllByNombre(textoBusqueda);
    }

    public void eliminarPlaneta(Long id) {
        planetaRepository.deleteById(id);
    }*/

}