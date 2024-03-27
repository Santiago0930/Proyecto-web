package co.edu.javeriana.proyecto_web.model;

import jakarta.persistence.*;

@Entity
public class Tripulante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuario;
    private String contrasenia;
    private String rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nave_id")
    private NaveComerciante nave;

    public Tripulante() { 
    }

    public Tripulante(String usuario, String contrasenia, String rol) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public NaveComerciante getNave() {
        return this.nave;
    }

    public void setNave(NaveComerciante nave) {
        this.nave = nave;
    }
    
    
}
