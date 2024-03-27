package co.edu.javeriana.proyecto_web.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Estrella {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double x;
    private double y;
    private double z;
    private String nombre;
    private boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "naveE_id")
    private NaveComerciante naveE;

    @OneToMany(mappedBy = "estrella", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Planeta> planetas = new ArrayList<>();

    public Estrella() { 
    }

    public Estrella(double x, double y, double z, String nombre, boolean estado) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.nombre = nombre;
        this.estado = estado;
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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public NaveComerciante getNaveE() {
        return this.naveE;
    }

    public void setNaveE(NaveComerciante naveE) {
        this.naveE = naveE;
    }

    public List<Planeta> getPlanetas() {
        return this.planetas;
    }

    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }

    public boolean agregarPlaneta(Planeta planeta){
        return planetas.add(planeta);
    }

}