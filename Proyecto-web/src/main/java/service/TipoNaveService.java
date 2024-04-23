package co.edu.javeriana.proyecto_web.service;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.TipoNave;
import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import co.edu.javeriana.proyecto_web.repository.TipoNaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.javeriana.proyecto_web.util.NotFoundException;

@Service
public class TipoNaveService {
    @Autowired
    private TipoNaveRepository tipoNaveRepository;


    public List<TipoNave> listarTipos() {
        return tipoNaveRepository.findAll();
    }

    public TipoNave recuperarTipoNave(Long id) {
        return tipoNaveRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    /*public void guardarTipoNave(TipoNave tipoNave) {
        tipoNaveRepository.save(tipoNave);
    }

    public List<TipoNave> buscarPorNombre(String textoBusqueda) {
        return tipoNaveRepository.findAllByNombre(textoBusqueda);
    }

    public void eliminarTipoNave(Long id) {
        tipoNaveRepository.deleteById(id);
    }*/
    
}