package co.edu.javeriana.proyecto_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.javeriana.proyecto_web.model.Producto;
import co.edu.javeriana.proyecto_web.service.ProductoService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Secured({ "CAPITAN", "COMERCIANTE"})
    @GetMapping("/list")
    @Transactional
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @Secured({ "CAPITAN", "COMERCIANTE"})
    @GetMapping("/{idProducto}")
    @Transactional
    public Producto obtenerProducto(@PathVariable Long idProducto) {
        return productoService.obtenerProducto(idProducto);
    }

}
