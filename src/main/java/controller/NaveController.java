package co.edu.javeriana.proyecto_web.controller;

import java.util.List;
import javax.validation.Valid;

import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import co.edu.javeriana.proyecto_web.service.NaveService;
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
@RequestMapping("/nave")
public class NaveController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private NaveService naveService;

    @GetMapping("/list")
    public String listarNaves(Model model) {
        List<NaveComerciante> naves = naveService.listarNaves();
        model.addAttribute("naves", naves);
        return "nave-list";
    }

    @GetMapping("/view/{idNave}")
    String verNave(Model model, @PathVariable("idNave") Long id) {
        NaveComerciante nave = naveService.recuperarNave(id);
        model.addAttribute("nave", nave);
        return "nave-view";
    }

    @GetMapping("/edit-form/{id}")
    public String formularioEditarNave(Model model, @PathVariable Long id) {
        NaveComerciante n = naveService.recuperarNave(id);
        model.addAttribute("nave", n);
        return "nave-edit";
    }

    @PostMapping(value = "/save")
    public String guardarNave(@Valid NaveComerciante nave, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "nave-edit";
        }
        naveService.guardarNave(nave);
        return "redirect:/nave/list";
    }

    @GetMapping("/buscar")
    public String listNaves(@RequestParam(required = false) String searchText, Model model) {
        List<NaveComerciante> naves;
        if (searchText == null || searchText.trim().equals("")) {
            log.info("No hay texto de búsqueda. Retornando todo");
            naves = naveService.listarNaves();
        } else {
            log.info("Buscando naves cuyo nombre comienza con {}", searchText);
            naves = naveService.buscarPorNombre(searchText);
        }
        model.addAttribute("naves", naves);
        return "nave-buscar";
    }

    @GetMapping("/create-form")
    public String mostrarFormularioCreacionNave(Model model) {
    model.addAttribute("nave", new NaveComerciante());
    return "nave-añadir";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarNave(@PathVariable("id") Long id) {
    naveService.eliminarNave(id);
    return "redirect:/nave/list";
    }

}
