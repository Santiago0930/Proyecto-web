package co.edu.javeriana.proyecto_web.model;

import jakarta.persistence.*;

@Entity
public class Planeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne(mappedBy = "comercioPl")
    private Comercio comercioPlaneta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estrella_id")
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

    public Comercio getComercioPlaneta() {
        return this.comercioPlaneta;
    }

    public void setComercioPlaneta(Comercio comercioPlaneta) {
        this.comercioPlaneta = comercioPlaneta;
    }

    public Estrella getEstrella() {
        return this.estrella;
    }

    public void setEstrella(Estrella estrella) {
        this.estrella = estrella;
    }
    
}