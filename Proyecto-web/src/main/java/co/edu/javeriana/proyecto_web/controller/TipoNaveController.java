package co.edu.javeriana.proyecto_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.javeriana.proyecto_web.model.TipoNave;
import co.edu.javeriana.proyecto_web.service.TipoNaveService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/tipoNave")
public class TipoNaveController {

    @Autowired
    private TipoNaveService naveService;

    @Secured({ "COMERCIANTE"})
    @GetMapping("/list")
    @Transactional
    public List<TipoNave> listarNaves() {
        return naveService.listarTipos();
    }

    @Secured({ "COMERCIANTE", "PILOTO", "CAPITAN"})
    @GetMapping("/{idNave}")
    @Transactional
    public TipoNave recuperarNave(@PathVariable Long idNave) {
        return naveService.recuperarTipoNave(idNave);
    }

}
