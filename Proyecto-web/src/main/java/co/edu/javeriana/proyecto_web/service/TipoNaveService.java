package co.edu.javeriana.proyecto_web.service;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.TipoNave;
import co.edu.javeriana.proyecto_web.repository.TipoNaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.javeriana.proyecto_web.util.NotFoundException;

import jakarta.transaction.Transactional;

@Service
public class TipoNaveService {
    @Autowired
    private TipoNaveRepository tipoNaveRepository;

    @Transactional
    public List<TipoNave> listarTipos() {
        return tipoNaveRepository.findAll();
    }

    @Transactional
    public TipoNave recuperarTipoNave(Long id) {
        return tipoNaveRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    
}