package co.edu.javeriana.proyecto_web.repository;

import java.util.Optional;

import co.edu.javeriana.proyecto_web.model.Tripulante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripulanteRepository extends JpaRepository<Tripulante, Long> {
    
     Optional<Tripulante> findByUsuario(String usuario);

     @Query("SELECT p.naveT.id FROM Tripulante p WHERE p.usuario = :usuario")
     Long obtenerNaveTripulante(@Param("usuario") String usuario);

}