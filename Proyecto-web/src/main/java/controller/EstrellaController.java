package co.edu.javeriana.proyecto_web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import co.edu.javeriana.proyecto_web.model.Estrella;
import co.edu.javeriana.proyecto_web.service.EstrellaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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

    /*@GetMapping("/view/{idEstrella}")
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
    }*/

}
