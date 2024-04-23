package co.edu.javeriana.proyecto_web.model;
import java.util.*;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double volumen;

    @OneToMany(mappedBy = "productoB", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BodegaNave> bodegaP = new ArrayList<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PlanetaXProducto> plaXpro = new ArrayList<>();

    public Producto() { 
    }

    public Producto(String nombre, Double volumen) {
        this.nombre = nombre;
        this.volumen = volumen;
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

    public Double getVolumen() {
        return this.volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public List<BodegaNave> getBodegaP() {
        return this.bodegaP;
    }

    public void setBodegaP(List<BodegaNave> bodegaP) {
        this.bodegaP = bodegaP;
    }

    public List<PlanetaXProducto> getPlaXpro() {
        return this.plaXpro;
    }

    public void setPlaXpro(List<PlanetaXProducto> plaXpro) {
        this.plaXpro = plaXpro;
    }

}