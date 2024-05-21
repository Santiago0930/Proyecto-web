package co.edu.javeriana.proyecto_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.javeriana.proyecto_web.model.BodegaNave;
import co.edu.javeriana.proyecto_web.service.BodegaNaveService;
import jakarta.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

@RestController
@RequestMapping("/bodeganave")
public class BodegaNaveController {

    @Autowired
    private BodegaNaveService bodegaService;

    @Secured({ "CAPITAN", "COMERCIANTE"})
    @GetMapping("/list/{idNave}")
    @Transactional
    public List<BodegaNave> listarBodegas(@PathVariable Long idNave) {
        return bodegaService.listarBodegas(idNave);
    }

    @Secured({ "CAPITAN", "COMERCIANTE"})
    @GetMapping("/{idNave}/{idProducto}")
    @Transactional
    public BodegaNave obtenerStock(@PathVariable Long idNave, @PathVariable Long idProducto) {
        return bodegaService.obtenerStock(idNave, idProducto);
    }

    @Secured({ "CAPITAN", "COMERCIANTE"})
    @PatchMapping("/modificar/{idNave}/{idProducto}")
    @Transactional
    public ResponseEntity<Object> modificarStock(@PathVariable Long idNave,@PathVariable Long idProducto, @RequestBody Integer stockNuevo){
        Object respuesta = bodegaService.modificarStock(idNave, idProducto,stockNuevo);
        return ResponseEntity.ok().body(respuesta);
    }
    
}
