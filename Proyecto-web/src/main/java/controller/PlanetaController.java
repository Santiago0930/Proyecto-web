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
import co.edu.javeriana.proyecto_web.model.Planeta;
import co.edu.javeriana.proyecto_web.service.PlanetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/planeta")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    @GetMapping("/list/{idEstrella}")
    public List<Planeta> listarPlanetas(@PathVariable Long idEstrella) {
        return planetaService.listarPlanetas(idEstrella);
    }

    @Operation(summary = "Buscar planeta por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontró el planeta", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Planeta.class)) }),
            @ApiResponse(responseCode = "400", description = "Id suministrado es invalido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Planeta no encontrada", content = @Content) })
    @GetMapping("/{idPlaneta}")
    public Planeta recuperarPlaneta(@PathVariable Long idPlaneta) {
        return planetaService.recuperarPlaneta(idPlaneta);
    }

    /*@GetMapping("/view/{idPlaneta}")
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
    }*/

}
