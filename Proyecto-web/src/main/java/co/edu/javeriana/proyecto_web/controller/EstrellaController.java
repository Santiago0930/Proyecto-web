package co.edu.javeriana.proyecto_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.javeriana.proyecto_web.model.Estrella;
import co.edu.javeriana.proyecto_web.service.EstrellaService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/estrella")
public class EstrellaController {

    @Autowired
    private EstrellaService estrellaService;

    @Secured({ "CAPITAN", "PILOTO" })
    @GetMapping("/list/cercanas/{idNave}")
    @Transactional
    public List<Estrella> listarEstrellas(@PathVariable Long idNave) {
        return estrellaService.listarEstrellas(idNave);
    }

}
