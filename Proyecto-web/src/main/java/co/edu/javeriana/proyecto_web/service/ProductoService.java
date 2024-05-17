package co.edu.javeriana.proyecto_web.service;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.Producto;
import co.edu.javeriana.proyecto_web.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Transactional
    public Producto obtenerProducto(Long idProducto){
        return productoRepository.obtenerProducto(idProducto);
    }

}