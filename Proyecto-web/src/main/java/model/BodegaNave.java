package co.edu.javeriana.proyecto_web.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BodegaNave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nave_id")
    @JsonIgnore
    private NaveComerciante naveB;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    @JsonIgnore
    private Producto productoB;

    public BodegaNave() { 
    }

    public BodegaNave(int stock) {
        this.stock = stock;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public NaveComerciante getNaveB() {
        return this.naveB;
    }

    public void setNaveB(NaveComerciante naveB) {
        this.naveB = naveB;
    }

    public Producto getProductoB() {
        return this.productoB;
    }

    public void setProductoB(Producto productoB) {
        this.productoB = productoB;
    }

}