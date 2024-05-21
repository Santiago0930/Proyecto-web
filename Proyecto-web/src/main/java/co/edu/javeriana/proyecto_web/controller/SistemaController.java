package co.edu.javeriana.proyecto_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.javeriana.proyecto_web.service.SistemaService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/sistema")
public class SistemaController {

    @Autowired
    private SistemaService sistemaService;

    @Secured({ "COMERCIANTE", "CAPITAN", "PILOTO" })
    @GetMapping("/obtener")
    @Transactional
    public Long obtenerTiempo() {
        return sistemaService.obtenerTiempo();
    }

}
