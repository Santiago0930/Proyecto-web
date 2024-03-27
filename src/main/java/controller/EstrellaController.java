package co.edu.javeriana.proyecto_web.controller;

import java.util.List;
import javax.validation.Valid;

import co.edu.javeriana.proyecto_web.model.Estrella;
import co.edu.javeriana.proyecto_web.service.EstrellaService;
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
@RequestMapping("/estrella")
public class EstrellaController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private EstrellaService estrellaService;

    @GetMapping("/list")
    public String listarEstrellas(Model model) {
        List<Estrella> estrellas = estrellaService.listarEstrellas();
        model.addAttribute("estrellas", estrellas);
        return "estrella-list";
    }

    @GetMapping("/view/{idEstrella}")
    String verEstrella(Model model, @PathVariable("idEstrella") Long id) {
        Estrella estrella = estrellaService.recuperarEstrella(id);
        model.addAttribute("estrella", estrella);
        return "estrella-view";
    }

    @GetMapping("/edit-form/{id}")
    public String formularioEditarEstrella(Model model, @PathVariable Long id) {
        Estrella e = estrellaService.recuperarEstrella(id);
        model.addAttribute("estrella", e);
        return "estrella-edit";
    }

    @PostMapping(value = "/save")
    public String guardarEstrella(@Valid Estrella estrella, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "estrella-edit";
        }
        estrellaService.guardarEstrella(estrella);
        return "redirect:/estrella/list";
    }

    @GetMapping("/buscar")
    public String listEstrellas(@RequestParam(required = false) String searchText, Model model) {
        List<Estrella> estrellas;
        if (searchText == null || searchText.trim().equals("")) {
            log.info("No hay texto de búsqueda. Retornando todo");
            estrellas = estrellaService.listarEstrellas();
        } else {
            log.info("Buscando estrellas cuyo nombre comienza con {}", searchText);
            estrellas = estrellaService.buscarPorNombre(searchText);
        }
        model.addAttribute("estrellas", estrellas);
        return "estrella-buscar";
    }

    @GetMapping("/create-form")
    public String mostrarFormularioCreacionEstrella(Model model) {
    model.addAttribute("estrella", new Estrella());
    return "estrella-añadir";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarEstrella(@PathVariable("id") Long id) {
    estrellaService.eliminarEstrella(id);
    return "redirect:/estrella/list";
    }

}
