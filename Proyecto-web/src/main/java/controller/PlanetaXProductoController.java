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
import co.edu.javeriana.proyecto_web.model.PlanetaXProducto;
import co.edu.javeriana.proyecto_web.service.PlanetaXProductoService;
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
@RequestMapping("/api/PxP")
public class PlanetaXProductoController {

    @Autowired
    private PlanetaXProductoService pxpService;

    @GetMapping("/list/{idPlaneta}")
    public List<PlanetaXProducto> listarPxP(@PathVariable Long idPlaneta) {
        return pxpService.listarPxP(idPlaneta);
    }

    @GetMapping("/listpreciov/{idPlaneta}")
    public List<Integer> listarPrecioVenta(@PathVariable Long idPlaneta) {
        return pxpService.listarPrecioVenta(idPlaneta);
    }

    @GetMapping("/listprecioc/{idPlaneta}")
    public List<Integer> listarPrecioCompra(@PathVariable Long idPlaneta) {
        return pxpService.listarPrecioCompra(idPlaneta);
    }

    @GetMapping("/{idPlaneta}/{idProducto}")
    public PlanetaXProducto obtenerPxP(@PathVariable Long idPlaneta, @PathVariable Long idProducto) {
        return pxpService.obtenerpxp(idPlaneta, idProducto);
    }

    @PatchMapping("/modificar/{idPlaneta}/{idProducto}")
    public ResponseEntity<Object> modificarStock(@PathVariable Long idPlaneta,@PathVariable Long idProducto, @RequestBody Integer stockNuevo){
        Object respuesta = pxpService.modificarStock(idPlaneta, idProducto, stockNuevo);
        return ResponseEntity.ok().body(respuesta);
    }

}