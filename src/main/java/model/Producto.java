package co.edu.javeriana.proyecto_web.model;

import jakarta.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precioUnitarioCompra;
    private Double precioUnitarioVenta;
    private int stock;
    private Double volumen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "naveP_id")
    private NaveComerciante naveP;

    @OneToOne(mappedBy = "comercioPr")
    private Comercio comercioProducto;

    public Producto() { 
    }

    public Producto(String nombre, Double precioUnitarioCompra, Double precioUnitarioVenta, int stock, Double volumen) {
        this.nombre = nombre;
        this.precioUnitarioCompra = precioUnitarioCompra;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.stock = stock;
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

    public Double getPrecioUnitarioCompra() {
        return this.precioUnitarioCompra;
    }

    public void setPrecioUnitarioCompra(Double precioUnitarioCompra) {
        this.precioUnitarioCompra = precioUnitarioCompra;
    }

    public Double getPrecioUnitarioVenta() {
        return this.precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(Double precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getVolumen() {
        return this.volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public NaveComerciante getNaveP() {
        return this.naveP;
    }

    public void setNaveP(NaveComerciante naveP) {
        this.naveP = naveP;
    }


    public Comercio getComercioProducto() {
        return this.comercioProducto;
    }

    public void setComercioProducto(Comercio comercioProducto) {
        this.comercioProducto = comercioProducto;
    }

}