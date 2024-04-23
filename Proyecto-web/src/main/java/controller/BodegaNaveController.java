package co.edu.javeriana.proyecto_web.controller;

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
import co.edu.javeriana.proyecto_web.model.BodegaNave;
import co.edu.javeriana.proyecto_web.service.BodegaNaveService;
import co.edu.javeriana.proyecto_web.model.Producto;
import co.edu.javeriana.proyecto_web.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/bodeganave")
public class BodegaNaveController {

    @Autowired
    private BodegaNaveService bodegaService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/list/{idNave}")
    public List<BodegaNave> listarBodegas(@PathVariable Long idNave) {
        return bodegaService.listarBodegas(idNave);
    }

    @GetMapping("/{idNave}/{idProducto}")
    public BodegaNave obtenerStock(@PathVariable Long idNave, @PathVariable Long idProducto) {
        return bodegaService.obtenerStock(idNave, idProducto);
    }

    @PatchMapping("/modificar/{idNave}/{idProducto}")
    public ResponseEntity<Object> modificarStock(@PathVariable Long idNave,@PathVariable Long idProducto, @RequestBody Integer stockNuevo){
        Object respuesta = bodegaService.modificarStock(idNave, idProducto,stockNuevo);
        return ResponseEntity.ok().body(respuesta);
    }

    /*@GetMapping("/view/{idBodega}")
    String verStock(Model model, @PathVariable("idBodega") Long id) {
        BodegaNave stockProducto = bodegaService.recuperarStock(id);
        model.addAttribute("stockProducto", stockProducto);
        return "bodega-view";
    }

    @GetMapping("/edit-form/{id}")
    public String formularioEditarStock(Model model, @PathVariable Long id) {
        BodegaNave stock = bodegaService.recuperarStock(id);
        model.addAttribute("stock", stock);
        return "bodega-edit";
    }

    @PostMapping(value = "/save")
    public String guardarStock(@Valid BodegaNave stock, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "bodega-edit";
        }
        bodegaService.guardarStock(stock);
        return "redirect:/bodega/list";
    }

    /*@GetMapping("/buscar")
    public String listStock(@RequestParam(required = false) String searchText, Model model) {
        List<BodegaNave> stocks;
        if (searchText == null || searchText.trim().isEmpty()) {
            log.info("No hay texto de búsqueda. Retornando todo");
            stocks = bodegaService.listarStocks();
        } else {
            log.info("Buscando productos cuyo nombre comienza con {}", searchText);
            List<Producto> productos = productoService.buscarPorNombre(searchText);
            if (!productos.isEmpty()) {
                List<Long> idsProductos = productos.stream().map(Producto::getId).collect(Collectors.toList());
                stocks = bodegaService.listarStocksPorIdsProductos(idsProductos);
            } else {
                stocks = new ArrayList<>();
            }
        }
        model.addAttribute("stocks", stocks);
        return "bodega-buscar";
    }
*/
    /*@GetMapping("/create-form")
    public String mostrarFormularioCreacionStock(Model model) {
    model.addAttribute("stock", new BodegaNave());
    return "nave-añadir";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarStock(@PathVariable("id") Long id) {
    bodegaService.eliminarStock(id);
    return "redirect:/bodega/list";
    }*/

}
