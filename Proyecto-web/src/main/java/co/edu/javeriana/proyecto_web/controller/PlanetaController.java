package co.edu.javeriana.proyecto_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.javeriana.proyecto_web.model.Planeta;
import co.edu.javeriana.proyecto_web.service.PlanetaService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/planeta")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @Secured({ "CAPITAN", "COMERCIANTE"})
    @GetMapping("/list/{idEstrella}")
    @Transactional
    public List<Planeta> listarPlanetas(@PathVariable Long idEstrella) {
        return planetaService.listarPlanetas(idEstrella);
    }

    @Secured({ "CAPITAN", "COMERCIANTE" })
    @GetMapping("/{idPlaneta}")
    @Transactional
    public Planeta recuperarPlaneta(@PathVariable Long idPlaneta) {
        return planetaService.recuperarPlaneta(idPlaneta);
    }

}
