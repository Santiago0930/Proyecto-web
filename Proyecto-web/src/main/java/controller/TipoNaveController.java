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
import co.edu.javeriana.proyecto_web.model.TipoNave;
import co.edu.javeriana.proyecto_web.service.TipoNaveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/tipoNave")
public class TipoNaveController {

    @Autowired
    private TipoNaveService naveService;

    @GetMapping("/list")
    public List<TipoNave> listarNaves() {
        return naveService.listarTipos();
    }

    @Operation(summary = "Buscar tipo nave por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontró la nave", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TipoNave.class)) }),
            @ApiResponse(responseCode = "400", description = "Id suministrado es invalido", content = @Content),
            @ApiResponse(responseCode = "404", description = "nave no encontrada", content = @Content) })

    @GetMapping("/{idNave}")
    public TipoNave recuperarNave(@PathVariable Long idNave) {
        return naveService.recuperarTipoNave(idNave);
    }

    /*@GetMapping("/view/{idNave}")
    String verNave(Model model, @PathVariable("idNave") Long id) {
        TipoNave nave = naveService.recuperarTipoNave(id);
        model.addAttribute("nave", nave);
        return "nave-view";
    }

    @GetMapping("/edit-form/{id}")
    public String formularioEditarNave(Model model, @PathVariable Long id) {
        TipoNave n = naveService.recuperarTipoNave(id);
        model.addAttribute("nave", n);
        return "nave-edit";
    }

    @PostMapping(value = "/save")
    public String guardarNave(@Valid TipoNave nave, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "nave-edit";
        }
        naveService.guardarTipoNave(nave);
        return "redirect:/nave/list";
    }

    @GetMapping("/buscar")
    public String listNaves(@RequestParam(required = false) String searchText, Model model) {
        List<TipoNave> naves;
        if (searchText == null || searchText.trim().equals("")) {
            log.info("No hay texto de búsqueda. Retornando todo");
            naves = naveService.listarTipos();
        } else {
            log.info("Buscando naves cuyo nombre comienza con {}", searchText);
            naves = naveService.buscarPorNombre(searchText);
        }
        model.addAttribute("naves", naves);
        return "nave-buscar";
    }

    @GetMapping("/create-form")
    public String mostrarFormularioCreacionNave(Model model) {
    model.addAttribute("nave", new TipoNave());
    return "nave-añadir";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarNave(@PathVariable("id") Long id) {
    naveService.eliminarTipoNave(id);
    return "redirect:/nave/list";
    }*/

}
