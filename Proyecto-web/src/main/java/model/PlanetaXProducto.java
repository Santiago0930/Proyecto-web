package co.edu.javeriana.proyecto_web.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PlanetaXProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int factorOferta;
    private int factorDemanda;
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planeta_id")
    @JsonIgnore
    private Planeta planeta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    @JsonIgnore
    private Producto producto;

    public PlanetaXProducto() { 
    }

    public PlanetaXProducto(int factorDemanda, int factorOferta, int stock) {
        this.factorDemanda = factorDemanda;
        this.factorOferta = factorOferta;
        this.stock = stock;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFactorOferta() {
        return this.factorOferta;
    }

    public void setFactorOferta(int factorOferta) {
        this.factorOferta = factorOferta;
    }

    public int getFactorDemanda() {
        return this.factorDemanda;
    }

    public void setFactorDemanda(int factorDemanda) {
        this.factorDemanda = factorDemanda;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Planeta getPlaneta() {
        return this.planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}