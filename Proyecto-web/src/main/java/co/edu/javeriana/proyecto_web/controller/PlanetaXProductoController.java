package co.edu.javeriana.proyecto_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.javeriana.proyecto_web.model.PlanetaXProducto;
import co.edu.javeriana.proyecto_web.service.PlanetaXProductoService;
import jakarta.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;


@RestController
@RequestMapping("/PxP")
public class PlanetaXProductoController {

    @Autowired
    private PlanetaXProductoService pxpService;

    @Secured({ "CAPITAN", "COMERCIANTE"})
    @GetMapping("/list/{idPlaneta}")
    @Transactional
    public List<PlanetaXProducto> listarPxP(@PathVariable Long idPlaneta) {
        return pxpService.listarPxP(idPlaneta);
    }

    @Secured({ "CAPITAN", "COMERCIANTE"})
    @GetMapping("/listpreciov/{idPlaneta}")
    @Transactional
    public List<Integer> listarPrecioVenta(@PathVariable Long idPlaneta) {
        return pxpService.listarPrecioVenta(idPlaneta);
    }

    @Secured({ "CAPITAN", "COMERCIANTE"})
    @GetMapping("/listprecioc/{idPlaneta}")
    @Transactional
    public List<Integer> listarPrecioCompra(@PathVariable Long idPlaneta) {
        return pxpService.listarPrecioCompra(idPlaneta);
    }

    @Secured({ "CAPITAN", "COMERCIANTE"})
    @GetMapping("/{idPlaneta}/{idProducto}")
    @Transactional
    public PlanetaXProducto obtenerPxP(@PathVariable Long idPlaneta, @PathVariable Long idProducto) {
        return pxpService.obtenerpxp(idPlaneta, idProducto);
    }

    @Secured({ "CAPITAN", "COMERCIANTE"})
    @PatchMapping("/modificar/{idPlaneta}/{idProducto}")
    @Transactional
    public ResponseEntity<Object> modificarStock(@PathVariable Long idPlaneta,@PathVariable Long idProducto, @RequestBody Integer stockNuevo){
        Object respuesta = pxpService.modificarStock(idPlaneta, idProducto, stockNuevo);
        return ResponseEntity.ok().body(respuesta);
    }

}