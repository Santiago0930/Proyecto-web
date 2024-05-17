package co.edu.javeriana.proyecto_web.service;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.BodegaNave;
import co.edu.javeriana.proyecto_web.repository.BodegaNaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class BodegaNaveService {
    @Autowired
    private BodegaNaveRepository bodegaRepository;

    @Transactional
    public List<BodegaNave> listarBodegas(Long id) {
        return bodegaRepository.obtenerStocks(id);
    }

    @Transactional
    public BodegaNave obtenerStock(Long idNave, Long idProducto){
        return bodegaRepository.obtenerStock(idNave, idProducto);
    }

    @Transactional
    public int modificarStock(Long idNave, Long idProducto, int stockNuevo ){
        return bodegaRepository.modificarStock(idNave, idProducto, stockNuevo);
    }

}