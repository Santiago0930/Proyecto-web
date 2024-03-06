package co.edu.javeriana.proyecto_web.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class NaveComerciante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double dinero;
    private String nombre;
    private Double bodega;
    private Double velocidad;
    private Double tiempo;

    @OneToMany(mappedBy = "nave", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Tripulante> tripulantes = new ArrayList<>();

    @OneToMany(mappedBy = "naveP", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Producto> productos = new ArrayList<>();

    @OneToMany(mappedBy = "naveE", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Estrella> estrellas = new ArrayList<>();

    public NaveComerciante() { 
    }

    public NaveComerciante(Double dinero, String nombre, Double bodega, Double velocidad, Double tiempo) {
        this.dinero = dinero;
        this.nombre = nombre;
        this.bodega = bodega;
        this.velocidad = velocidad;
        this.tiempo = tiempo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDinero() {
        return this.dinero;
    }

    public void setDinero(Double dinero) {
        this.dinero = dinero;
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

    public Double getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(Double tiempo) {
        this.tiempo = tiempo;
    }

    public List<Tripulante> getTripulantes() {
        return this.tripulantes;
    }

    public boolean agregarTripulante(Tripulante tripulante){
        return tripulantes.add(tripulante);
    }

    public boolean agregarProducto(Producto producto){
        return productos.add(producto);
    }

    public boolean agregarEstrella(Estrella estrella){
        return estrellas.add(estrella);
    }

}