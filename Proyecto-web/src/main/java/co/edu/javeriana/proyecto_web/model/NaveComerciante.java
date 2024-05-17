package co.edu.javeriana.proyecto_web.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class NaveComerciante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double x;
    private double y;
    private double z;
    private int dinero;
    private int tiempo;

    @OneToOne
    @JoinColumn(name = "tipoNave_id")
    @JsonIgnore
    private TipoNave tipoNave;

    @OneToMany(mappedBy = "naveT", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Tripulante> tripulantes = new ArrayList<>();

    @OneToMany(mappedBy = "naveB", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BodegaNave> bodega = new ArrayList<>();

    @ManyToMany(mappedBy = "naves")
    @JsonIgnore
    private List<Estrella> estrellas = new ArrayList<>();

    public NaveComerciante() { 
    }

    public NaveComerciante(double x, double y, double z, int dinero, int tiempo) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.dinero = dinero;
        this.tiempo = tiempo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public int getDinero() {
        return this.dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public TipoNave getTipoNave() {
        return this.tipoNave;
    }

    public void setTipoNave(TipoNave tipoNave) {
        this.tipoNave = tipoNave;
    }

    public List<Tripulante> getTripulantes() {
        return this.tripulantes;
    }

    public void setTripulantes(List<Tripulante> tripulantes) {
        this.tripulantes = tripulantes;
    }

    public List<BodegaNave> getBodega() {
        return this.bodega;
    }

    public void setBodega(List<BodegaNave> bodega) {
        this.bodega = bodega;
    }

    public List<Estrella> getEstrellas() {
        return this.estrellas;
    }

    public void setEstrellas(List<Estrella> estrellas) {
        this.estrellas = estrellas;
    }    

    /*public boolean agregarTripulante(Tripulante tripulante){
        return tripulantes.add(tripulante);
    }

    public boolean agregarProducto(Producto producto){
        return productos.add(producto);
    }

    public boolean agregarEstrella(Estrella estrella){
        return estrellas.add(estrella);
    }
*/
}