package co.edu.javeriana.proyecto_web.service;

import java.util.List;

import co.edu.javeriana.proyecto_web.model.Producto;
import co.edu.javeriana.proyecto_web.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto recuperarProducto(Long id) {
        return productoRepository.findById(id).orElseThrow();
    }

    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public List<Producto> buscarPorNombre(String textoBusqueda) {
        return productoRepository.findAllByNombre(textoBusqueda);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

}