package co.edu.javeriana.proyecto_web.model;
import java.util.*;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Planeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "planeta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PlanetaXProducto> plaXpro = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estrella_id")
    @JsonIgnore
    private Estrella estrella;

    public Planeta() { 
    }

    public Planeta(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PlanetaXProducto> getPlaXpro() {
        return this.plaXpro;
    }

    public void setPlaXpro(List<PlanetaXProducto> plaXpro) {
        this.plaXpro = plaXpro;
    }

    public Estrella getEstrella() {
        return this.estrella;
    }

    public void setEstrella(Estrella estrella) {
        this.estrella = estrella;
    }
    
}