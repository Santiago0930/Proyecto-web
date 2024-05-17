package co.edu.javeriana.proyecto_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
