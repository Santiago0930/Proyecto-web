package co.edu.javeriana.proyecto_web.model;
import java.util.*;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long tiempoPartida;

    public Sistema() { 
    }

    public Sistema(Long tiempoPartida) {
        this.tiempoPartida = tiempoPartida;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTiempoPartida() {
        return this.tiempoPartida;
    }

    public void setTiempoPartida(Long tiempoPartida) {
        this.tiempoPartida = tiempoPartida;
    }
    
}