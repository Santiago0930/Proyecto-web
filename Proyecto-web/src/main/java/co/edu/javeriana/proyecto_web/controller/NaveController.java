package co.edu.javeriana.proyecto_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import co.edu.javeriana.proyecto_web.service.NaveService;
import jakarta.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

@RestController
@RequestMapping("/nave")
public class NaveController {

    @Autowired
    private NaveService naveService;

    @Secured({ "CAPITAN", "COMERCIANTE", "PILOTO" })
    @GetMapping("/obtenerTipo/{id}")
    @Transactional
    public Long obtenerIdTipoNave(@PathVariable Long id){
        return naveService.obtenerIdTipoNave(id);
    }

    @Secured({ "CAPITAN", "PILOTO", "COMERCIANTE" })
    @GetMapping("/{idNave}")
    @Transactional
    public NaveComerciante recuperarNave(@PathVariable Long idNave) {
        return naveService.recuperarNave(idNave);
    }

    @Secured({ "CAPITAN", "PILOTO", "COMERCIANTE" })
    @GetMapping("/dinero/{idNave}")
    @Transactional
    public int obtenerDinero(@PathVariable Long idNave) {
        return naveService.obtenerDinero(idNave);
    }

    @Secured({ "CAPITAN", "PILOTO", "COMERCIANTE" })
    @PatchMapping("/modificar/{idNave}")
    @Transactional
    public ResponseEntity<Object> modificarDinero(@PathVariable Long idNave, @RequestBody Integer dinero){
        Object respuesta = naveService.modificarDinero(idNave, dinero);
        return ResponseEntity.ok().body(respuesta);
    }

    @Secured({ "CAPITAN", "PILOTO", "COMERCIANTE" })
    @PatchMapping("/actualizar/{idNave}")
    @Transactional
    public ResponseEntity<Object> actualizarTiempo(@PathVariable Long idNave, @RequestBody Integer tiempo){
        Object respuesta = naveService.actualizarTiempo(idNave, tiempo);
        return ResponseEntity.ok().body(respuesta);
    }

    @Secured({ "CAPITAN", "PILOTO" })
    @PatchMapping("/actualizarx/{idNave}")
    @Transactional
    public ResponseEntity<Object> actualizarX(@PathVariable Long idNave, @RequestBody Double x){
        Object respuesta = naveService.actualizarX(idNave, x);
        return ResponseEntity.ok().body(respuesta);
    }

    @Secured({ "CAPITAN", "PILOTO" })
    @PatchMapping("/actualizary/{idNave}")
    @Transactional
    public ResponseEntity<Object> actualizarY(@PathVariable Long idNave, @RequestBody Double y){
        Object respuesta = naveService.actualizarY(idNave, y);
        return ResponseEntity.ok().body(respuesta);
    }

    @Secured({ "CAPITAN", "PILOTO" })
    @PatchMapping("/actualizarz/{idNave}")
    @Transactional
    public ResponseEntity<Object> actualizarZ(@PathVariable Long idNave, @RequestBody Double z){
        Object respuesta = naveService.actualizarZ(idNave, z);
        return ResponseEntity.ok().body(respuesta);
    }

}