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
import co.edu.javeriana.proyecto_web.model.NaveComerciante;
import co.edu.javeriana.proyecto_web.service.NaveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/nave")
public class NaveController {

    @Autowired
    private NaveService naveService;

    /*@GetMapping("/list")
    public List<TipoNave> listarNaves() {
        return naveService.listarTipos();
    }
*/
    @Operation(summary = "Buscar tipo nave por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontró la nave", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = NaveComerciante.class)) }),
            @ApiResponse(responseCode = "400", description = "Id suministrado es invalido", content = @Content),
            @ApiResponse(responseCode = "404", description = "nave no encontrada", content = @Content) })

    @GetMapping("/{idNave}")
    public NaveComerciante recuperarNave(@PathVariable Long idNave) {
        return naveService.recuperarNave(idNave);
    }

    @GetMapping("/dinero/{idNave}")
    public int obtenerDinero(@PathVariable Long idNave) {
        return naveService.obtenerDinero(idNave);
    }

    @PatchMapping("/modificar/{idNave}")
    public ResponseEntity<Object> modificarDinero(@PathVariable Long idNave, @RequestBody Integer dinero){
        Object respuesta = naveService.modificarDinero(idNave, dinero);
        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("/actualizar/{idNave}")
    public ResponseEntity<Object> actualizarTiempo(@PathVariable Long idNave, @RequestBody Integer tiempo){
        Object respuesta = naveService.actualizarTiempo(idNave, tiempo);
        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("/actualizarx/{idNave}")
    public ResponseEntity<Object> actualizarX(@PathVariable Long idNave, @RequestBody Double x){
        Object respuesta = naveService.actualizarX(idNave, x);
        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("/actualizary/{idNave}")
    public ResponseEntity<Object> actualizarY(@PathVariable Long idNave, @RequestBody Double y){
        Object respuesta = naveService.actualizarY(idNave, y);
        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("/actualizarz/{idNave}")
    public ResponseEntity<Object> actualizarZ(@PathVariable Long idNave, @RequestBody Double z){
        Object respuesta = naveService.actualizarZ(idNave, z);
        return ResponseEntity.ok().body(respuesta);
    }

}