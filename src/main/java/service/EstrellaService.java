package co.edu.javeriana.proyecto_web.service;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.Estrella;
import co.edu.javeriana.proyecto_web.repository.EstrellaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstrellaService {
    @Autowired
    private EstrellaRepository estrellaRepository;

    public List<Estrella> listarEstrellas() {
        return estrellaRepository.findAll();
    }

    public Estrella recuperarEstrella(Long id) {
        return estrellaRepository.findById(id).orElseThrow();
    }

    public void guardarEstrella(Estrella estrella) {
        estrellaRepository.save(estrella);
    }

    public List<Estrella> buscarPorNombre(String textoBusqueda) {
        return estrellaRepository.findAllByNombre(textoBusqueda);
    }

    public void eliminarEstrella(Long id) {
        estrellaRepository.deleteById(id);
    }

}