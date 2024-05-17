package co.edu.javeriana.proyecto_web.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class AgujeroGusano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double tiempoViaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estrellaOrigen_id")
    @JsonIgnore
    private Estrella estrellaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estrellaDestino_id")
    @JsonIgnore
    private Estrella estrellaDestino;

    public AgujeroGusano(){
    }
    
    public AgujeroGusano(double tiempoViaje) { 
        this.tiempoViaje = tiempoViaje;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTiempoViaje() {
        return this.tiempoViaje;
    }

    public void setTiempoViaje(double tiempoViaje) {
        this.tiempoViaje = tiempoViaje;
    }

    public Estrella getEstrellaOrigen() {
        return this.estrellaOrigen;
    }

    public void setEstrellaOrigen(Estrella estrellaOrigen) {
        this.estrellaOrigen = estrellaOrigen;
    }

    public Estrella getEstrellaDestino() {
        return this.estrellaDestino;
    }

    public void setEstrellaDestino(Estrella estrellaDestino) {
        this.estrellaDestino = estrellaDestino;
    }    

}