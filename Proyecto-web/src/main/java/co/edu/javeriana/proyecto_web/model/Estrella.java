package co.edu.javeriana.proyecto_web.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToMany
    @JoinTable(
      name = "NaveXEstrella", 
      joinColumns = @JoinColumn(name = "estrella_id"), 
      inverseJoinColumns = @JoinColumn(name = "nave_id"))
    @JsonIgnore
    private List<NaveComerciante> naves = new ArrayList<>();

    @OneToMany(mappedBy = "estrella", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Planeta> planetas = new ArrayList<>();

    @OneToMany(mappedBy = "estrellaOrigen", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AgujeroGusano> agujerosOrigen = new ArrayList<>();

    @OneToMany(mappedBy = "estrellaOrigen", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AgujeroGusano> agujerosDestino = new ArrayList<>();

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

    public List<NaveComerciante> getNaves() {
        return this.naves;
    }

    public void setNaves(List<NaveComerciante> naves) {
        this.naves = naves;
    }

    public List<Planeta> getPlanetas() {
        return this.planetas;
    }

    public void setPlanetas(List<Planeta> planetas) {
        this.planetas = planetas;
    }

    public List<AgujeroGusano> getAgujerosOrigen() {
        return this.agujerosOrigen;
    }

    public void setAgujerosOrigen(List<AgujeroGusano> agujerosOrigen) {
        this.agujerosOrigen = agujerosOrigen;
    }

    public List<AgujeroGusano> getAgujerosDestino() {
        return this.agujerosDestino;
    }

    public void setAgujerosDestino(List<AgujeroGusano> agujerosDestino) {
        this.agujerosDestino = agujerosDestino;
    }

    public boolean agregarPlaneta(Planeta planeta){
        return planetas.add(planeta);
    }

}