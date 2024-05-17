package co.edu.javeriana.proyecto_web.service;

import co.edu.javeriana.proyecto_web.model.Sistema;
import co.edu.javeriana.proyecto_web.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class SistemaService {
    @Autowired
    private SistemaRepository sistemaRepository;

    @Transactional
    public Long obtenerTiempo() {
        Sistema sistema =  sistemaRepository.findFirstByOrderByIdAsc();
        return sistema.getTiempoPartida();
    }
}