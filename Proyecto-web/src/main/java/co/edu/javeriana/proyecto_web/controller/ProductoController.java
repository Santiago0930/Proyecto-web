package co.edu.javeriana.proyecto_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import co.edu.javeriana.proyecto_web.model.Producto;
import co.edu.javeriana.proyecto_web.service.ProductoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/list")
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/{idProducto}")
    public Producto obtenerProducto(@PathVariable Long idProducto) {
        return productoService.obtenerProducto(idProducto);
    }

}
