package co.edu.javeriana.proyecto_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import co.edu.javeriana.proyecto_web.model.Estrella;
import co.edu.javeriana.proyecto_web.service.EstrellaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/estrella")
public class EstrellaController {

    @Autowired
    private EstrellaService estrellaService;

    @GetMapping("/list/cercanas/{idNave}")
    public List<Estrella> listarEstrellas(@PathVariable Long idNave) {
        return estrellaService.listarEstrellas(idNave);
    }

}
