package co.edu.javeriana.proyecto_web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int factorDemanda;
    private int factorOferta;

    @OneToOne
    private Producto comercioPr;

    @OneToOne
    private Planeta comercioPl;

    public Comercio() { 
    }

    public Comercio(int factorDemanda, int factorOferta) {
        this.factorDemanda = factorDemanda;
        this.factorOferta = factorOferta;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFactorDemanda() {
        return this.factorDemanda;
    }

    public void setFactorDemanda(int factorDemanda) {
        this.factorDemanda = factorDemanda;
    }

    public int getFactorOferta() {
        return this.factorOferta;
    }

    public void setFactorOferta(int factorOferta) {
        this.factorOferta = factorOferta;
    }
    
    public Producto getComercioPr() {
        return this.comercioPr;
    }

    public void setComercioPr(Producto comercioPr) {
        this.comercioPr = comercioPr;
    }

    public Planeta getComercioPl() {
        return this.comercioPl;
    }

    public void setComercioPl(Planeta comercioPl) {
        this.comercioPl = comercioPl;
    }

}