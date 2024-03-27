package co.edu.javeriana.proyecto_web.controller;

import java.util.List;
import javax.validation.Valid;

import co.edu.javeriana.proyecto_web.model.Tripulante;
import co.edu.javeriana.proyecto_web.service.TripulanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tripulante")
public class TripulanteController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TripulanteService tripulanteService;

    @GetMapping("/list")
    public String listarTripulantes(Model model) {
        List<Tripulante> tripulantes = tripulanteService.listarTripulantes();
        model.addAttribute("tripulantes", tripulantes);
        return "tripulante-list";
    }

    @GetMapping("/view/{idTripulante}")
    String verTripulante(Model model, @PathVariable("idTripulante") Long id) {
        Tripulante tripulante = tripulanteService.recuperarTripulante(id);
        model.addAttribute("tripulante", tripulante);
        return "tripulante-view";
    }

    @GetMapping("/edit-form/{id}")
    public String formularioEditarTripulante(Model model, @PathVariable Long id) {
        Tripulante t = tripulanteService.recuperarTripulante(id);
        model.addAttribute("tripulante", t);
        return "tripulante-edit";
    }

    @PostMapping(value = "/save")
    public String guardarTripulante(@Valid Tripulante tripulante, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "tripulante-edit";
        }
        tripulanteService.guardarTripulante(tripulante);
        return "redirect:/tripulante/list";
    }

    @GetMapping("/buscar")
    public String listTripulantes(@RequestParam(required = false) String searchText, Model model) {
        List<Tripulante> tripulantes;
        if (searchText == null || searchText.trim().equals("")) {
            log.info("No hay texto de búsqueda. Retornando todo");
            tripulantes = tripulanteService.listarTripulantes();
        } else {
            log.info("Buscando tripulantes cuyo nombre comienza con {}", searchText);
            tripulantes = tripulanteService.buscarPorUsuario(searchText);
        }
        model.addAttribute("tripulantes", tripulantes);
        return "tripulante-buscar";
    }

    @GetMapping("/create-form")
    public String mostrarFormularioCreacionTripulante(Model model) {
    model.addAttribute("tripulante", new Tripulante());
    return "tripulante-añadir";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarTripulante(@PathVariable("id") Long id) {
    tripulanteService.eliminartripulante(id);
    return "redirect:/tripulante/list";
    }

}
