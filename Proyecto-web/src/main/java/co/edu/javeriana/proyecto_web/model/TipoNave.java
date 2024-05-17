package co.edu.javeriana.proyecto_web.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TipoNave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private Double bodega;
    private Double velocidad;

    @OneToOne(mappedBy= "tipoNave", cascade = CascadeType.ALL)
    @JsonIgnore
    private NaveComerciante nave;

    public TipoNave() { 
    }

    public TipoNave(String nombre, Double bodega, Double velocidad) {
        this.nombre = nombre;
        this.bodega = bodega;
        this.velocidad = velocidad;
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

    public Double getBodega() {
        return this.bodega;
    }

    public void setBodega(Double bodega) {
        this.bodega = bodega;
    }

    public Double getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public NaveComerciante getNave() {
        return this.nave;
    }

    public void setNave(NaveComerciante nave) {
        this.nave = nave;
    }        

}