package co.edu.javeriana.proyecto_web.service;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import co.edu.javeriana.proyecto_web.repository.NaveComRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaveService {
    @Autowired
    private NaveComRepository naveRepository;

    public List<NaveComerciante> listarNaves() {
        return naveRepository.findAll();
    }

    public NaveComerciante recuperarNave(Long id) {
        return naveRepository.findById(id).orElseThrow();
    }

    public void guardarNave(NaveComerciante nave) {
        naveRepository.save(nave);
    }

    public List<NaveComerciante> buscarPorNombre(String textoBusqueda) {
        return naveRepository.findAllByNombre(textoBusqueda);
    }

    public void eliminarNave(Long id) {
        naveRepository.deleteById(id);
    }

}