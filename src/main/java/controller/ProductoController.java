package co.edu.javeriana.proyecto_web.controller;

import java.util.List;
import javax.validation.Valid;

import co.edu.javeriana.proyecto_web.model.Producto;
import co.edu.javeriana.proyecto_web.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductoService productoService;

    @GetMapping("/list")
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.listarProductos();
        model.addAttribute("productos", productos);
        return "producto-list";
    }

    @GetMapping("/view/{idProducto}")
    String verProducto(Model model, @PathVariable("idProducto") Long id) {
        Producto producto = productoService.recuperarProducto(id);
        model.addAttribute("producto", producto);
        return "producto-view";
    }

    @GetMapping("/edit-form/{id}")
    public String formularioEditarProducto(Model model, @PathVariable Long id) {
        Producto p = productoService.recuperarProducto(id);
        model.addAttribute("producto", p);
        return "producto-edit";
    }

    @PostMapping(value = "/save")
    public String guardarProducto(@Valid Producto producto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "producto-edit";
        }
        productoService.guardarProducto(producto);
        return "redirect:/producto/list";
    }

    @GetMapping("/buscar")
    public String listProductos(@RequestParam(required = false) String searchText, Model model) {
        List<Producto> productos;
        if (searchText == null || searchText.trim().equals("")) {
            log.info("No hay texto de búsqueda. Retornando todo");
            productos = productoService.listarProductos();
        } else {
            log.info("Buscando productos cuyo nombre comienza con {}", searchText);
            productos = productoService.buscarPorNombre(searchText);
        }
        model.addAttribute("productos", productos);
        return "producto-buscar";
    }

    @GetMapping("/create-form")
    public String mostrarFormularioCreacionProducto(Model model) {
    model.addAttribute("producto", new Producto());
    return "producto-añadir";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) {
    productoService.eliminarProducto(id);
    return "redirect:/producto/list";
    }

}
