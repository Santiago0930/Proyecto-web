package co.edu.javeriana.proyecto_web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import co.edu.javeriana.proyecto_web.repository.NaveComRepository;
import org.springframework.beans.factory.annotation.Autowired;
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