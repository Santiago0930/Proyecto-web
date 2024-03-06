package co.edu.javeriana.proyecto_web.controller;

import java.util.List;
import javax.validation.Valid;

import co.edu.javeriana.proyecto_web.model.Planeta;
import co.edu.javeriana.proyecto_web.service.PlanetaService;
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
@RequestMapping("/planeta")
public class PlanetaController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PlanetaService planetaService;

    @GetMapping("/list")
    public String listarPlanetas(Model model) {
        List<Planeta> planetas = planetaService.listarPlanetas();
        model.addAttribute("planetas", planetas);
        return "planeta-list";
    }

    @GetMapping("/view/{idPlaneta}")
    String verPlaneta(Model model, @PathVariable("idPlaneta") Long id) {
        Planeta planeta = planetaService.recuperarPlaneta(id);
        model.addAttribute("planeta", planeta);
        return "planeta-view";
    }

    @GetMapping("/edit-form/{id}")
    public String formularioEditarPlaneta(Model model, @PathVariable Long id) {
        Planeta p = planetaService.recuperarPlaneta(id);
        model.addAttribute("planeta", p);
        return "planeta-edit";
    }

    @PostMapping(value = "/save")
    public String guardarPlaneta(@Valid Planeta planeta, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "planeta-edit";
        }
        planetaService.guardarPlaneta(planeta);
        return "redirect:/planeta/list";
    }

    @GetMapping("/buscar")
    public String listPlanetas(@RequestParam(required = false) String searchText, Model model) {
        List<Planeta> planetas;
        if (searchText == null || searchText.trim().equals("")) {
            log.info("No hay texto de búsqueda. Retornando todo");
            planetas = planetaService.listarPlanetas();
        } else {
            log.info("Buscando planetas cuyo nombre comienza con {}", searchText);
            planetas = planetaService.buscarPorNombre(searchText);
        }
        model.addAttribute("planetas", planetas);
        return "planeta-buscar";
    }

    @GetMapping("/create-form")
    public String mostrarFormularioCreacionPlaneta(Model model) {
    model.addAttribute("planeta", new Planeta());
    return "planeta-añadir";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarPlaneta(@PathVariable("id") Long id) {
    planetaService.eliminarPlaneta(id);
    return "redirect:/planeta/list";
    }

}
