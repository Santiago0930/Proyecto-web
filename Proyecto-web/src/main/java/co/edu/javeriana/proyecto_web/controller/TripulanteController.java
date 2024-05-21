package co.edu.javeriana.proyecto_web.controller;

import co.edu.javeriana.proyecto_web.service.TripulanteService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tripulante")
public class TripulanteController {

    @Autowired
    private TripulanteService tripulanteService;

    @Secured({ "CAPITAN", "COMERCIANTE", "PILOTO" })
    @GetMapping("/obtenerNave/{nombreUsuario}")
    @Transactional
    public Long obtenerNaveTripulante(@PathVariable String nombreUsuario){
        return tripulanteService.obtenerNaveTripulante(nombreUsuario);
    }
}
