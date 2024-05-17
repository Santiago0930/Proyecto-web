package co.edu.javeriana.proyecto_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import co.edu.javeriana.proyecto_web.model.BodegaNave;
import co.edu.javeriana.proyecto_web.service.BodegaNaveService;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/bodeganave")
public class BodegaNaveController {

    @Autowired
    private BodegaNaveService bodegaService;

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
    
}
