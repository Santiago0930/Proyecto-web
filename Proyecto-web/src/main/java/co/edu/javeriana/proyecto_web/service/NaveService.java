package co.edu.javeriana.proyecto_web.service;

import org.springframework.beans.factory.annotation.Autowired;
import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import co.edu.javeriana.proyecto_web.repository.NaveComRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class NaveService {
    @Autowired
    private NaveComRepository naveRepository;

    @Transactional
    public NaveComerciante recuperarNave(Long id) {
        return naveRepository.obtenerNave(id);
    }

    @Transactional
    public int obtenerDinero(Long idNave){
        return naveRepository.obtenerDinero(idNave);
    }

    @Transactional
    public int modificarDinero(Long idNave, int dinero ){
        return naveRepository.modificarDinero(idNave, dinero);
    }

    @Transactional
    public int actualizarTiempo(Long idNave, int tiempo ){
        return naveRepository.actualizarTiempo(idNave, tiempo);
    }

    @Transactional
    public int actualizarX(Long idNave, double x ){
        return naveRepository.actualizarX(idNave, x);
    }

    @Transactional
    public int actualizarY(Long idNave, double y ){
        return naveRepository.actualizarY(idNave, y);
    }

    @Transactional
    public int actualizarZ(Long idNave, double z ){
        return naveRepository.actualizarZ(idNave, z);
    }

}