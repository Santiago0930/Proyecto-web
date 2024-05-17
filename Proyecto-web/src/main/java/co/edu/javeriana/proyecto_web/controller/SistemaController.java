package co.edu.javeriana.proyecto_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import co.edu.javeriana.proyecto_web.service.SistemaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/sistema")
public class SistemaController {

    @Autowired
    private SistemaService sistemaService;

    @GetMapping("/obtener")
    public Long obtenerTiempo() {
        return sistemaService.obtenerTiempo();
    }

}
